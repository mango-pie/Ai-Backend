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
 * 图片资源表 实体类。
 *
 * @author 芒果派
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("blog_image")
public class BlogImage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 图片ID
     */
    @Id(keyType = KeyType.Auto)
    private Long id;

    /**
     * 原始文件名
     */
    private String filename;

    /**
     * 存储文件名
     */
    private String storageName;

    /**
     * 访问URL
     */
    private String url;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * MIME类型
     */
    private String type;

    /**
     * 图片宽度
     */
    private Integer width;

    /**
     * 图片高度
     */
    private Integer height;

    /**
     * 关联文章ID
     */
    private Long postId;

    /**
     * 上传用户ID
     */
    private Long userId;

    /**
     * 使用类型（1-封面，2-内容图片，3-其他）
     */
    private Integer usageType;

    /**
     * 状态（0-删除，1-正常）
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

}
