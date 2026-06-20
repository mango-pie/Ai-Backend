package com.ai.model.vo.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyHabitVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private String title;

    private String description;

    private String icon;

    private String color;

    private Integer targetDaysPerWeek;

    private Integer streakCount;

    private Integer bestStreak;

    private String lastCheckDate;

    private Boolean checkedToday;

    private Integer weekCheckedDays;

    private Integer sortOrder;

    private Integer status;
}
