package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyChecklistAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long taskId;

    private String title;

    private Integer sortOrder;
}
