package com.ai.model.vo.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyFocusSessionVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Long taskId;

    private String taskTitle;

    private Integer focusType;

    private Integer plannedMinutes;

    private Integer actualSeconds;

    private Integer status;

    private String startedTime;

    private String endedTime;

    private Integer pauseTotalSeconds;
}
