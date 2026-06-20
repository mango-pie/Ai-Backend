package com.ai.service;

import com.ai.model.dto.diary.DiaryEntryQueryRequest;
import com.ai.model.dto.diary.DiaryEntrySaveRequest;
import com.ai.model.entity.DiaryEntry;
import com.ai.model.vo.diary.DiaryEntryMonthItemVO;
import com.ai.model.vo.diary.DiaryEntryPrevNextVO;
import com.ai.model.vo.diary.DiaryEntryVO;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.service.IService;
import java.time.LocalDate;
import java.util.List;

public interface DiaryEntryService extends IService<DiaryEntry> {

    long saveDiaryEntry(DiaryEntrySaveRequest request, Long userId);

    DiaryEntryVO getDiaryEntryVO(Long id, Long userId);

    DiaryEntryVO getByDate(LocalDate date, Long userId);

    boolean deleteDiaryEntry(Long id, Long userId);

    Page<DiaryEntryVO> queryPage(DiaryEntryQueryRequest request, Long userId);

    List<DiaryEntryMonthItemVO> listByMonth(int year, int month, Long userId);

    DiaryEntryPrevNextVO getPrevNext(Long id, Long userId);
}
