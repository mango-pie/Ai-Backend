package com.ai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "chat.segmentation")
public class ChatSegmentationProperties {

    private boolean enabled = true;

    private String style = "natural";

    private int minLength = 15;

    private int maxSegments = 8;

    private double temperature = 0.3;

    private int maxTokens = 600;

    private double timeoutSeconds = 12.0;

    private double delayBase = 0.35;

    private double delayPerChar = 0.015;

    private double delayMax = 1.2;

    /** LLM 分段失败或未拆分时，是否用标点规则兜底 */
    private boolean fallbackToRules = true;
}
