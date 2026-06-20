package com.ai.service;

import com.ai.model.dto.study.*;
import com.ai.model.entity.StudyTask;
import com.ai.model.vo.study.StudyBlogSyncVO;
import com.ai.model.vo.study.StudyTaskVO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;

public interface StudyTaskService extends IService<StudyTask> {

    long addTask(StudyTaskAddRequest request, Long userId);

    boolean updateTask(StudyTaskUpdateRequest request, Long userId);

    boolean toggleTask(StudyTaskToggleRequest request, Long userId);

    boolean deleteTask(Long id, Long userId);

    StudyTaskVO getTaskVO(Long id, Long userId);

    Page<StudyTaskVO> queryTaskView(StudyTaskViewQueryRequest request, Long userId);

    boolean sortTasks(StudyTaskSortRequest request, Long userId);

    boolean moveTasks(StudyTaskMoveRequest request, Long userId);

    StudyBlogSyncVO syncBlogDrafts(Long userId);

    StudyTask getOwnedTask(Long taskId, Long userId);
}
