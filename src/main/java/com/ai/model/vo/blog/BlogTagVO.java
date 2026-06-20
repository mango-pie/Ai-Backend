package com.ai.model.vo.blog;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BlogTagVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private String color;

    private Integer count;

    private Integer status;

    private String statusText;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
