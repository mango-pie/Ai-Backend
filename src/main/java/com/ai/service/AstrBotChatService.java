package com.ai.service;

import com.ai.model.dto.chat.ChatMessageSegment;
import com.ai.model.vo.chat.ChatConfigVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * AstrBot 聊天代理服务接口（BFF 模式）。
 * 聊天角色全部由 AstrBot 平台预设驱动；后端仅做代理、会话隔离、历史落库。
 */
public interface AstrBotChatService {

    /**
     * 健康探测：AstrBot 是否可达。
     */
    boolean isAvailable();

    /**
     * 拉取 AstrBot 可用预设/配置列表（对应 GET /api/v1/configs）。
     */
    List<ChatConfigVO> listConfigs();

    /**
     * 流式对话。
     *
     * @param username   必填，对应 AstrBot username（建议 user_{userId}）
     * @param sessionId  会话 id（角色聊天：chat_user_{userId}_cfg_{configId}_conv_{conversationId}）
     * @param configId   可选，角色/预设标识（用于 session 隔离和 SSE type 标记；如 AstrBot 支持可透传）
     * @param message    用户消息文本（当前阶段纯文本；未来支持 segments 富消息）
     * @return 文本 chunk 流（内部使用 Flux<String> 作为契约，上层 Controller 负责 SSE 包装）
     */
    Flux<String> streamChat(String username, String sessionId, String configId, String message,
                            List<ChatMessageSegment> segments);

    /**
     * 净化 AstrBot 回复（去除思维链、插件思考步骤、情感状态块等）。
     */
    String cleanDisplayContent(String raw);
}