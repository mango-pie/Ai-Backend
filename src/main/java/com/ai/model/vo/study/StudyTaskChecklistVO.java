package com.ai.model.vo.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyTaskChecklistVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long taskId;

    private String title;

    private Integer done;

    private Integer sortOrder;
}
