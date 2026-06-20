package com.ai.service;

import com.ai.model.vo.study.StudyWorkspaceVO;

public interface StudyWorkspaceService {

    StudyWorkspaceVO initWorkspace(Long userId, boolean createThemeLists);
}
