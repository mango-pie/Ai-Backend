package com.ai.config.redis;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 探测 Redis 是否可用，并写入 Session / 自动配置相关属性。
 */
public final class RedisAvailabilityConfigurer {

    public static final String PROPERTY = "app.redis.available";
    private static final String MODE_PROPERTY = "app.redis.mode";
    private static final String REDIS_AUTO_CONFIG =
            "org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration";
    private static final String REDIS_REACTIVE_AUTO_CONFIG =
            "org.springframework.boot.autoconfigure.data.redis.RedisReactiveAutoConfiguration";
    private static final String SESSION_AUTO_CONFIG =
            "org.springframework.boot.autoconfigure.session.SessionAutoConfiguration";

    private RedisAvailabilityConfigurer() {
    }

    public static void apply(ConfigurableEnvironment environment) {
        String mode = environment.getProperty(MODE_PROPERTY, "auto").trim().toLowerCase();
        boolean available = resolveAvailability(environment, mode);

        Map<String, Object> props = new HashMap<>();
        props.put(PROPERTY, Boolean.toString(available));
        props.put("spring.session.store-type", available ? "redis" : "none");

        if (!available) {
            mergeAutoConfigureExclude(environment, props, REDIS_AUTO_CONFIG);
            mergeAutoConfigureExclude(environment, props, REDIS_REACTIVE_AUTO_CONFIG);
            mergeAutoConfigureExclude(environment, props, SESSION_AUTO_CONFIG);
        }

        environment.getPropertySources().addFirst(new MapPropertySource("redisAvailability", props));
        System.out.println("[Redis] mode=" + mode + ", available=" + available
                + ", session=" + (available ? "redis" : "servlet(in-memory)"));
    }

    private static void mergeAutoConfigureExclude(ConfigurableEnvironment environment,
                                                  Map<String, Object> props,
                                                  String excludeClass) {
        String existing = environment.getProperty("spring.autoconfigure.exclude", "");
        if (existing.isBlank()) {
            props.put("spring.autoconfigure.exclude", excludeClass);
        } else if (!existing.contains(excludeClass)) {
            props.put("spring.autoconfigure.exclude", existing + "," + excludeClass);
        }
    }

    private static boolean resolveAvailability(ConfigurableEnvironment environment, String mode) {
        return switch (mode) {
            case "on", "true", "required" -> true;
            case "off", "false", "disabled" -> false;
            default -> pingRedis(environment);
        };
    }

    private static boolean pingRedis(ConfigurableEnvironment environment) {
        String host = environment.getProperty("spring.data.redis.host", "127.0.0.1");
        int port = environment.getProperty("spring.data.redis.port", Integer.class, 6379);
        int timeoutMs = environment.getProperty("app.redis.ping-timeout-ms", Integer.class, 2000);
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeoutMs);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
