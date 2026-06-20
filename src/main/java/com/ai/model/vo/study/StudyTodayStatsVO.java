package com.ai.model.vo.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyTodayStatsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String date;

    private Integer totalTasks;

    private Integer completedTasks;

    private Integer overdueTasks;

    private Integer focusMinutes;

    private Integer habitsChecked;

    private Integer habitsTotal;
}
