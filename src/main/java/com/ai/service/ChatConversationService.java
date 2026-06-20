package com.ai.service;

import com.ai.model.entity.ChatConversation;
import com.ai.model.vo.chat.ChatConversationVO;
import com.mybatisflex.core.service.IService;

import java.util.List;

public interface ChatConversationService extends IService<ChatConversation> {

    /**
     * 获取或创建该用户在某角色下的默认会话。
     */
    ChatConversationVO resolveDefault(Long userId, String configId);

    /**
     * 新建非默认会话（同角色多会话）。
     */
    ChatConversationVO createConversation(Long userId, String configId, String title);

    /**
     * 列出用户会话，可按 configId 过滤。
     */
    List<ChatConversationVO> listConversations(Long userId, String configId);

    /**
     * 获取会话详情（含消息数）。
     */
    ChatConversationVO getConversationVO(Long conversationId, Long userId);

    /**
     * 获取并校验归属。
     */
    ChatConversation getOwnedConversation(Long conversationId, Long userId);

    /**
     * 软删会话。
     */
    boolean deleteConversation(Long conversationId, Long userId);

    /**
     * 更新最后消息时间。
     */
    void touchLastMessageAt(Long conversationId);
}
