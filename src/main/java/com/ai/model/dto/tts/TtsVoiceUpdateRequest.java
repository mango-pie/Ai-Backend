package com.ai.model.dto.tts;

import lombok.Data;

import java.io.Serializable;

@Data
public class TtsVoiceUpdateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String promptText;

    private String promptLang;

    private String textLang;

    private Integer status;

    private Integer sortOrder;
}
