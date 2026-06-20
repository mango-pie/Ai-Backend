package com.ai.model.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

import java.io.Serial;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文章标签关系表 实体类。
 *
 * @author 芒果派
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("blog_post_tag")
public class BlogPostTag implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 关系ID
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 文章ID
     */
    private Long postId;

    /**
     * 标签ID
     */
    private Long tagId;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

}
