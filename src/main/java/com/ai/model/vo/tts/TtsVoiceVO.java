package com.ai.model.vo.tts;

import lombok.Data;

import java.io.Serializable;

@Data
public class TtsVoiceVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String refAudioPath;

    private String promptText;

    private String promptLang;

    private String textLang;

    private Integer isDefault;

    private Integer status;

    private Integer sortOrder;
}
