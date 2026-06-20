package com.ai.service;

import org.springframework.web.multipart.MultipartFile;

public interface TtsRefAudioUploadService {

    String saveRefAudio(MultipartFile file, Long voiceId);
}
