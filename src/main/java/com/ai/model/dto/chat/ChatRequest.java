package com.ai.model.dto.chat;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ChatRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色聊天会话 id。与 configId 二选一；同时传时以 conversationId 为准。
     */
    private Long conversationId;

    /**
     * AstrBot 配置/预设 id。未传 conversationId 时必填，将自动 resolve 默认会话。
     */
    private String configId;

    /**
     * 用户消息（纯文本）。当 segments 为空或 null 时使用此字段。
     */
    private String message;

    /**
     * 富消息段（可选）。Ask 模式使用；Agent 模式暂仅支持纯文本 message。
     */
    private List<ChatMessageSegment> segments;

    /**
     * 聊天模式：ask（默认）| agent
     */
    private String mode;

    /**
     * Agent 模式下 L2 工具用户确认后继续执行时传入（二期）。
     */
    private String confirmToken;
}
