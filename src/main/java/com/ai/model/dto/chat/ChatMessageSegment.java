package com.ai.model.dto.chat;

import lombok.Data;

import java.io.Serializable;

/**
 * 聊天消息段（用于未来支持 AstrBot 的消息链：plain/image/record/file 等）。
 * 目前主要为扩展预留，当前实现可仅使用 ChatRequest.message 纯文本。
 */
@Data
public class ChatMessageSegment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 段类型：plain, image, record, file, video, reply 等（对齐 AstrBot）
     */
    private String type;

    /**
     * 文本内容（type=plain 时使用）
     */
    private String text;

    /**
     * 附件 id（来自 AstrBot /api/v1/file 上传，或未来本地上传后映射）
     */
    private String attachmentId;

    // 可扩展其他字段如 message_id, selected_text 等
}