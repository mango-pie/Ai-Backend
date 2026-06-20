package com.ai.model.dto.blog;

import com.ai.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class BlogPostQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String summary;

    private Long categoryId;

    private Long userId;

    private Integer status;

    private Integer isTop;

    private Long tagId;

    private String searchText;
}
