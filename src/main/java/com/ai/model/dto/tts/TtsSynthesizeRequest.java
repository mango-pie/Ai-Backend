package com.ai.model.dto.tts;

import lombok.Data;

import java.io.Serializable;

@Data
public class TtsSynthesizeRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String text;

    private Long voiceId;

    private String textLang;

    private Double speedFactor;

    private String textSplitMethod;

    private Object streamingMode;

    private String mediaType;
}
