package com.ai.model.dto.diary;

import com.ai.common.PageRequest;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DiaryEntryQueryRequest extends PageRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer status;
}
