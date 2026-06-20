package com.ai.model.vo.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyListVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private String name;

    private String color;

    private String icon;

    private Integer listType;

    private Integer sortOrder;

    private Integer taskCount;

    private Integer status;

    private String createdTime;

    private String updatedTime;
}
