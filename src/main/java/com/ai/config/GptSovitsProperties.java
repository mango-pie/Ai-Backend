package com.ai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "gpt-sovits")
public class GptSovitsProperties {

    private String baseUrl = "http://127.0.0.1:9880";

    private int connectTimeoutMs = 5000;

    private int readTimeoutMs = 120000;

    private RefAudio refAudio = new RefAudio();

    private SeedVoice seedVoice = new SeedVoice();

    @Data
    public static class RefAudio {
        private String uploadDir = "E:/app/tts-ref/";
        private int maxSizeMb = 10;
        private String allowedExt = "wav,mp3";
    }

    @Data
    public static class SeedVoice {
        private boolean enabled = true;
        private String name = "达妮娅";
        private String refAudioPath = "E:/Quark/gpt-vot/output.wav_0009342720.wav";
        private String promptText = "怎么啊？如果有你在也不放心，那就干脆给我也装个限制器或者炸弹喽";
        private String promptLang = "zh";
        private String textLang = "zh";
    }
}
