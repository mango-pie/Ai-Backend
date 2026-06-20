package com.ai.model.dto.blog;

import lombok.Data;

import java.io.Serializable;

@Data
public class BlogCategoryUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private String icon;

    private Integer sortOrder;

    private Integer status;
}
