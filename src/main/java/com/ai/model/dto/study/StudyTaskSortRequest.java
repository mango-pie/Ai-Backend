package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudyTaskSortRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long listId;

    private List<SortItem> items;

    @Data
    public static class SortItem implements Serializable {
        private Long id;
        private Integer sortOrder;
    }
}
