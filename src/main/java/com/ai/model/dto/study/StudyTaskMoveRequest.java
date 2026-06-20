package com.ai.model.dto.study;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StudyTaskMoveRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Long> taskIds;

    private Long targetListId;
}
