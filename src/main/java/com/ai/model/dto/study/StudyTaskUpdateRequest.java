package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyTaskUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private Long listId;

    private String content;

    private Integer priority;

    private String dueDate;

    private Boolean isToday;

    private Integer sortOrder;
}
