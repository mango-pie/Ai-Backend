package com.ai.model.vo.chat;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ChatMessageVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long conversationId;

    private String messageType;

    private String content;

    private String source;

    private Long parentId;

    private LocalDateTime createTime;
}
