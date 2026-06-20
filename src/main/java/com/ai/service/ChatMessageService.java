package com.ai.service;

import com.ai.model.entity.ChatMessage;
import com.ai.model.vo.chat.ChatMessageVO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;

import java.util.List;

public interface ChatMessageService extends IService<ChatMessage> {

    Long addMessage(Long conversationId, Long userId, String messageType, String content, String source);

    Page<ChatMessageVO> listByConversation(Long conversationId, Long userId, int pageNum, int pageSize);

    List<ChatMessageVO> listLatest(Long conversationId, Long userId, int limit);

    long countByConversation(Long conversationId);
}
