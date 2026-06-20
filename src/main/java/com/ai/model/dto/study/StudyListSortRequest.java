package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudyListSortRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<SortItem> items;

    @Data
    public static class SortItem implements Serializable {
        private Long id;
        private Integer sortOrder;
    }
}
