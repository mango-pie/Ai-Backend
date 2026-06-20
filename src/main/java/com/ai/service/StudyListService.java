package com.ai.service;

import com.ai.model.dto.study.StudyListAddRequest;
import com.ai.model.dto.study.StudyListSortRequest;
import com.ai.model.dto.study.StudyListUpdateRequest;
import com.ai.model.entity.StudyList;
import com.ai.model.vo.study.StudyListVO;
import com.mybatisflex.core.service.IService;

import java.util.List;

public interface StudyListService extends IService<StudyList> {

    long addList(StudyListAddRequest request, Long userId);

    boolean updateList(StudyListUpdateRequest request, Long userId);

    boolean deleteList(Long id, Long userId);

    List<StudyListVO> getAllLists(Long userId);

    boolean sortLists(StudyListSortRequest request, Long userId);

    StudyList getInboxList(Long userId);

    StudyList getOrCreateInbox(Long userId);

    void adjustTaskCount(Long listId, int delta);

    StudyList getOwnedList(Long listId, Long userId);

    void initDefaultLists(Long userId, boolean createThemeLists);
}
