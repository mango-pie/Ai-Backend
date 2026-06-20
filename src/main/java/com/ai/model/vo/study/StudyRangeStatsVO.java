package com.ai.model.vo.study;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudyRangeStatsVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer completedTaskCount;

    private Integer focusMinutes;

    private Integer habitCheckCount;

    private List<DailyBreakdown> dailyBreakdown;

    @Data
    public static class DailyBreakdown implements Serializable {
        private String date;
        private Integer completedTasks;
        private Integer focusMinutes;
    }
}
