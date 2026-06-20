package com.ai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "astrbot")
public class AstrBotProperties {

    private String baseUrl = "http://127.0.0.1:6185";

    private String apiKey = "";

    private int connectTimeoutMs = 5000;

    private int readTimeoutMs = 300000;
}