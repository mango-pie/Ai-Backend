package com.ai.model.vo.blog;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BlogImageVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String filename;

    private String storageName;

    private String url;

    private Long size;

    private String type;

    private Integer width;

    private Integer height;

    private Long postId;

    private Long userId;

    private String userName;

    private Integer usageType;

    private String usageTypeText;

    private Integer status;

    private String statusText;

    private LocalDateTime createdTime;
}
