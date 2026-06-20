package com.ai.model.vo.diary;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;

@Data
public class DiaryEntryPrevNextVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long prevId;

    private LocalDate prevDate;

    private String prevTitle;

    private Long nextId;

    private LocalDate nextDate;

    private String nextTitle;
}
