package com.ai.model.vo.blog;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BlogPostVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String summary;

    private String content;

    private String coverUrl;

    private Long categoryId;

    private String categoryName;

    private Long userId;

    private String userName;

    private String userAvatar;

    private Integer viewCount;

    private Integer likeCount;

    private Integer status;

    private String statusText;

    private Integer isTop;

    private Integer sortOrder;

    private String extendInfo;

    private List<BlogTagVO> tags;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
