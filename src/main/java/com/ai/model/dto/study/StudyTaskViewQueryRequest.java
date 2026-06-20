package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyTaskViewQueryRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String view;

    private Long listId;

    private Boolean hideCompleted;

    private Integer completedDays;

    private Integer pageNum;

    private Integer pageSize;
}
