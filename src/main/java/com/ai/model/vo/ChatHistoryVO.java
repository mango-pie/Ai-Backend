package com.ai.model.vo;

import com.ai.model.entity.ChatHistory;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 对话历史VO
 *
 * @author <a href="https://github.com/liyupi">scene</a>
 */
@Data
public class ChatHistoryVO implements Serializable {
    
    /**
     * id
     */
    private Long id;
    
    /**
     * 消息
     */
    private String message;
    
    /**
     * 消息类型
     */
    private String messageType;
    
    /**
     * 应用id
     */
    private Long appId;
    
    /**
     * 创建用户id
     */
    private Long userId;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 父消息id
     */
    private Long parentId;
    
    /**
     * 从实体对象创建VO
     *
     * @param chatHistory 对话历史实体
     * @return 对话历史VO
     */
    public static ChatHistoryVO fromEntity(ChatHistory chatHistory) {
        if (chatHistory == null) {
            return null;
        }
        ChatHistoryVO vo = new ChatHistoryVO();
        vo.setId(chatHistory.getId());
        vo.setMessage(chatHistory.getMessage());
        vo.setMessageType(chatHistory.getMessageType());
        vo.setAppId(chatHistory.getAppId());
        vo.setUserId(chatHistory.getUserId());
        vo.setCreateTime(chatHistory.getCreateTime());
        vo.setParentId(chatHistory.getParentId());
        return vo;
    }
}