package com.ai.model.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("tts_voice_profile")
public class TtsVoiceProfile implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Long id;

    private String name;

    private String refAudioPath;

    private String promptText;

    private String promptLang;

    private String textLang;

    private Integer isDefault;

    private Integer status;

    private Integer sortOrder;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
