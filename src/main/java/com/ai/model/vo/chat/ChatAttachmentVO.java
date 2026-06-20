package com.ai.model.vo.chat;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChatAttachmentVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String attachmentId;

    private String type;

    private String filename;
}
