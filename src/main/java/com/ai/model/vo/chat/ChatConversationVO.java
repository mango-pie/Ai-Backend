package com.ai.model.vo.chat;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ChatConversationVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String configId;

    private String configName;

    private String title;

    private Boolean isDefault;

    private LocalDateTime lastMessageAt;

    private LocalDateTime createTime;

    private Long messageCount;
}
