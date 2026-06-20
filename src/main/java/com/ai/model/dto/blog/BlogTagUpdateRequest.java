package com.ai.model.dto.blog;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlogTagUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private String color;

    private Integer count;

    private Integer status;
}
