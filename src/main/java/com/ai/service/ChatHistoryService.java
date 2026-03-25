package com.ai.service;

import com.ai.model.dto.chatHistory.ChatHistoryQueryRequest;
import com.ai.model.entity.User;
import com.ai.model.vo.ChatHistoryVO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.ai.model.entity.ChatHistory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 对话历史 服务层。
 *
 */
public interface ChatHistoryService extends IService<ChatHistory> {

    /**
     * 保存用户消息
     *
     * @param appId 应用id
     * @param userId 用户id
     * @param message 消息内容
     * @return 对话历史id
     */
    Long saveUserMessage(Long appId, Long userId, String message);

    /**
     * 保存AI消息
     *
     * @param appId 应用id
     * @param userId 用户id
     * @param message 消息内容
     * @param parentId 父消息id
     * @return 对话历史id
     */
    Long saveAiMessage(Long appId, Long userId, String message, Long parentId);

    /**
     * 保存错误消息
     *
     * @param appId 应用id
     * @param userId 用户id
     * @param message 错误信息
     * @param parentId 父消息id
     * @return 对话历史id
     */
    Long saveErrorMessage(Long appId, Long userId, String message, Long parentId);

    /**
     * 根据应用id删除对话历史
     *
     * @param appId 应用id
     * @return 是否删除成功
     */
    boolean deleteByAppId(Long appId);

    /**
     * 分页查询应用的对话历史
     *
     * @param chatHistoryQueryRequest 查询请求
     * @param appId 应用id
     * @param userId 用户id
     * @param isAdmin 是否是管理员
     * @return 分页结果
     */
    Page<ChatHistoryVO> listChatHistoryByPage(ChatHistoryQueryRequest chatHistoryQueryRequest, Long appId, Long userId, boolean isAdmin);

    /**
     * 管理员分页查询所有对话历史
     *
     * @param chatHistoryQueryRequest 查询请求
     * @return 分页结果
     */
    Page<ChatHistoryVO> listChatHistoryByPageForAdmin(ChatHistoryQueryRequest chatHistoryQueryRequest);

    /**
     * 获取应用的最新对话历史
     *
     * @param appId 应用id
     * @param limit 限制数量
     * @return 对话历史列表
     */
    List<ChatHistoryVO> getLatestChatHistory(Long appId, Integer limit);

    /**
     * 获取对话历史VO
     *
     * @param chatHistory 对话历史实体
     * @return 对话历史VO
     */
    ChatHistoryVO getChatHistoryVO(ChatHistory chatHistory);

    /**
     * 批量获取对话历史VO
     *
     * @param chatHistoryList 对话历史实体列表
     * @return 对话历史VO列表
     */
    List<ChatHistoryVO> getChatHistoryVOList(List<ChatHistory> chatHistoryList);

    QueryWrapper getQueryWrapper(ChatHistoryQueryRequest chatHistoryQueryRequest);

    boolean addChatMessage(Long appId, String message, String messageType, Long userId);

    Page<ChatHistory> listAppChatHistoryByPage(Long appId, int pageSize,
                                               LocalDateTime lastCreateTime,
                                               User loginUser);

    int loadChatHistoryToMemory(Long appId, MessageWindowChatMemory chatMemory, int maxCount);
}
