package com.ai.model.vo.blog;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BlogCategoryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private String icon;

    private Integer sortOrder;

    private Integer status;

    private String statusText;

    private Integer postCount;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
