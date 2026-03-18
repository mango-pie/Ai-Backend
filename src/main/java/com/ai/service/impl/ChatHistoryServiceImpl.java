package com.ai.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.ai.model.entity.ChatHistory;
import com.ai.mapper.ChatHistoryMapper;
import com.ai.service.ChatHistoryService;
import org.springframework.stereotype.Service;

/**
 * 对话历史 服务层实现。
 *
 * @author <a href="https://github.com/liyupi">scene</a>
 */
@Service
public class ChatHistoryServiceImpl extends ServiceImpl<ChatHistoryMapper, ChatHistory>  implements ChatHistoryService{

}
