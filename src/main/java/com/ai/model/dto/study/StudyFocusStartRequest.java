package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyFocusStartRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long taskId;

    private Integer focusType;

    private Integer plannedMinutes;
}
