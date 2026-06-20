package com.ai.service;

import com.ai.model.vo.study.StudyRangeStatsVO;
import com.ai.model.vo.study.StudyTodayStatsVO;

public interface StudyStatsService {

    StudyTodayStatsVO getTodayStats(Long userId);

    StudyRangeStatsVO getRangeStats(Long userId, String startDate, String endDate);
}
