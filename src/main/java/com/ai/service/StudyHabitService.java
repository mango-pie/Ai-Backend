package com.ai.service;

import com.ai.model.dto.study.StudyHabitAddRequest;
import com.ai.model.dto.study.StudyHabitCheckRequest;
import com.ai.model.dto.study.StudyHabitUpdateRequest;
import com.ai.model.entity.StudyHabit;
import com.ai.model.vo.study.StudyHabitVO;
import com.mybatisflex.core.service.IService;

import java.util.List;

public interface StudyHabitService extends IService<StudyHabit> {

    long addHabit(StudyHabitAddRequest request, Long userId);

    boolean updateHabit(StudyHabitUpdateRequest request, Long userId);

    boolean deleteHabit(Long id, Long userId);

    List<StudyHabitVO> listAllHabits(Long userId);

    boolean checkHabit(StudyHabitCheckRequest request, Long userId);

    boolean uncheckHabit(StudyHabitCheckRequest request, Long userId);

    List<String> getCheckCalendar(Long habitId, Long userId, int year, int month);
}
