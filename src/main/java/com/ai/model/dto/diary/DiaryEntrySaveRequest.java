package com.ai.model.dto.diary;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class DiaryEntrySaveRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate diaryDate;

    private String title;

    private String content;

    private String mood;

    private String weather;

    private List<String> tags;

    /** 0-草稿 1-完成 */
    private Integer status;

    private String coverUrl;
}
