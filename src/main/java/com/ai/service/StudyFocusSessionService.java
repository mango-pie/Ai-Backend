package com.ai.service;

import com.ai.model.dto.study.StudyFocusIdRequest;
import com.ai.model.dto.study.StudyFocusStartRequest;
import com.ai.model.entity.StudyFocusSession;
import com.ai.model.vo.study.StudyFocusSessionVO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;

public interface StudyFocusSessionService extends IService<StudyFocusSession> {

    StudyFocusSessionVO startFocus(StudyFocusStartRequest request, Long userId);

    StudyFocusSessionVO pauseFocus(StudyFocusIdRequest request, Long userId);

    StudyFocusSessionVO resumeFocus(StudyFocusIdRequest request, Long userId);

    StudyFocusSessionVO completeFocus(StudyFocusIdRequest request, Long userId);

    StudyFocusSessionVO abandonFocus(StudyFocusIdRequest request, Long userId);

    StudyFocusSessionVO getActiveFocus(Long userId);

    Page<StudyFocusSessionVO> listFocusPage(Long userId, int pageNum, int pageSize,
                                            String startDate, String endDate);
}
