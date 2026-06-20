package com.ai.model.vo.diary;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class DiaryEntryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private LocalDate diaryDate;

    private String title;

    private String content;

    private String mood;

    private String weather;

    private List<String> tags;

    private Integer status;

    private String statusText;

    private Integer wordCount;

    private String coverUrl;

    private String extendInfo;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
