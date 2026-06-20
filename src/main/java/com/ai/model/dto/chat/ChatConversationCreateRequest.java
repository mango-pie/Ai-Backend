package com.ai.model.dto.chat;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatConversationCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String configId;

    private String title;
}
