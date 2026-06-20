package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudyListAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String color;

    private String icon;

    private Integer sortOrder;
}
