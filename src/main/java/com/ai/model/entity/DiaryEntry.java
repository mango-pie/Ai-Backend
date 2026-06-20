package com.ai.model.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户日记表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("diary_entry")
public class DiaryEntry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Long id;

    private Long userId;

    private LocalDate diaryDate;

    private String title;

    private String content;

    private String mood;

    private String weather;

    /** JSON 数组字符串 */
    private String tags;

    /** 0-草稿 1-完成 */
    private Integer status;

    private Integer wordCount;

    private String coverUrl;

    /** JSON 扩展信息（AI 等） */
    private String extendInfo;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

    private LocalDateTime deletedTime;
}
