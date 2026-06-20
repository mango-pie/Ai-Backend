package com.ai.service;

import com.ai.model.dto.study.StudyChecklistAddRequest;
import com.ai.model.dto.study.StudyChecklistUpdateRequest;
import com.ai.model.entity.StudyTaskChecklist;
import com.ai.model.vo.study.StudyTaskChecklistVO;
import com.mybatisflex.core.service.IService;

import java.util.List;

public interface StudyTaskChecklistService extends IService<StudyTaskChecklist> {

    long addChecklist(StudyChecklistAddRequest request, Long userId);

    boolean updateChecklist(StudyChecklistUpdateRequest request, Long userId);

    boolean deleteChecklist(Long id, Long userId);

    List<StudyTaskChecklistVO> listByTaskId(Long taskId, Long userId);

    void softDeleteByTaskId(Long taskId);
}
