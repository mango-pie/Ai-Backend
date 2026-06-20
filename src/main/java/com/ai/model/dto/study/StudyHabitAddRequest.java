package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyHabitAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String description;

    private String icon;

    private String color;

    private Integer targetDaysPerWeek;
}
