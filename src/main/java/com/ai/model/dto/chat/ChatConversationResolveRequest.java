package com.ai.model.dto.chat;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatConversationResolveRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * AstrBot 预设/角色 id
     */
    private String configId;
}
