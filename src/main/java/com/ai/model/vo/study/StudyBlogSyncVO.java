package com.ai.model.vo.study;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudyBlogSyncVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer syncedCount;

    private List<Long> taskIds;
}
