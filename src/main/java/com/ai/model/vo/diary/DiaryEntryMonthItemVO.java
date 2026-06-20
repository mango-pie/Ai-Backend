package com.ai.model.vo.diary;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class DiaryEntryMonthItemVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDate diaryDate;

    private String title;

    private String mood;

    private Integer status;
}
