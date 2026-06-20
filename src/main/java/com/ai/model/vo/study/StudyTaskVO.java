package com.ai.model.vo.study;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudyTaskVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private Long listId;

    private String listName;

    private String title;

    private String content;

    private Integer status;

    private Integer priority;

    private String dueDate;

    private Integer isToday;

    private Integer sortOrder;

    private Integer sourceType;

    private Long sourceId;

    private String completedTime;

    private List<StudyTaskChecklistVO> checklistItems;

    private String createdTime;

    private String updatedTime;
}
