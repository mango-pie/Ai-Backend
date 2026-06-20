package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyHabitCheckRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long habitId;

    private String checkDate;
}
