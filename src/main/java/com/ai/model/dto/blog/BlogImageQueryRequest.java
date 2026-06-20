package com.ai.model.dto.blog;

import com.ai.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class BlogImageQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long postId;

    private Long userId;

    private Integer usageType;

    private Integer status;

    private String searchText;
}
