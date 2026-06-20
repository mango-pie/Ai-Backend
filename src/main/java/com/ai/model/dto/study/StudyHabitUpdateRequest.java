package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyHabitUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String description;

    private String icon;

    private String color;

    private Integer targetDaysPerWeek;

    private Integer sortOrder;

    private Integer status;
}
