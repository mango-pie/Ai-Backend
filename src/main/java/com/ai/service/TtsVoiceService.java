package com.ai.service;

import com.ai.model.dto.tts.TtsVoiceUpdateRequest;
import com.ai.model.entity.TtsVoiceProfile;
import com.ai.model.vo.tts.TtsVoiceVO;
import com.mybatisflex.core.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TtsVoiceService extends IService<TtsVoiceProfile> {

    void ensureSeedVoice();

    List<TtsVoiceVO> listVoices();

    TtsVoiceVO getVoiceVO(Long id);

    TtsVoiceProfile getVoiceOrDefault(Long voiceId);

    TtsVoiceProfile getDefaultVoice();

    long addVoice(MultipartFile file, String name, String promptText, String promptLang, String textLang);

    boolean updateVoice(TtsVoiceUpdateRequest request);

    boolean deleteVoice(Long id);

    void selectDefaultVoice(Long id);

    void initReferAudio(Long voiceId);

    boolean isRefPreloaded();
}
