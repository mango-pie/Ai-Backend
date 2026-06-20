package com.ai.service;

import com.ai.model.vo.study.StudyFocusSessionVO;
import com.ai.model.vo.study.StudyListVO;
import com.ai.model.vo.study.StudyTodayStatsVO;

import java.util.List;
import java.util.function.Supplier;

/**
 * 学习模块 Redis 缓存
 */
public interface StudyRedisCacheService {

    StudyTodayStatsVO getTodayStats(Long userId, Supplier<StudyTodayStatsVO> loader);

    void evictTodayStats(Long userId);

    List<StudyListVO> getLists(Long userId, Supplier<List<StudyListVO>> loader);

    void evictLists(Long userId);

    StudyFocusSessionVO getActiveFocus(Long userId);

    void setActiveFocus(Long userId, StudyFocusSessionVO session);

    void evictActiveFocus(Long userId);

    boolean tryInitLock(Long userId);

    void releaseInitLock(Long userId);
}
