package com.ai.config.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RedisFeatureLogger implements ApplicationRunner {

    @Value("${app.redis.available:false}")
    private boolean redisAvailable;

    @Override
    public void run(ApplicationArguments args) {
        if (redisAvailable) {
            log.info("Redis is available: session=Redis, chat memory=Redis, study cache=Redis");
        } else {
            log.warn("Redis unavailable: degraded mode (servlet in-memory session, no distributed cache). "
                    + "Start Redis on 127.0.0.1:6381 or set app.redis.mode=on to require Redis.");
        }
    }
}
