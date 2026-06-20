package com.ai.config.redis;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 兜底：即使 META-INF 注册未生效，main 方法注册此监听器也能正确降级。
 */
public class RedisAvailabilityListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        RedisAvailabilityConfigurer.apply(event.getEnvironment());
    }
}
