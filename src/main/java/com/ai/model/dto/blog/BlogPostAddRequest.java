package com.ai.model.dto.blog;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BlogPostAddRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private String summary;

    private String content;

    private String coverUrl;

    private Long categoryId;

    private List<Long> tagIds;

    private Integer status;

    private Integer isTop;

    private Integer sortOrder;

    private String extendInfo;
}
