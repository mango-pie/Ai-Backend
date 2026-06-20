package com.ai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "chat")
public class ChatAttachmentProperties {

    /**
     * 聊天图片 attachmentId -> caption 缓存 TTL（分钟）。
     */
    private int attachmentCacheTtlMinutes = 120;
}
