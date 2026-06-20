package com.ai.service;

/**
 * 智谱 Vision 图片描述（OpenAI 兼容多模态）。
 */
public interface ChatImageCaptionService {

    String caption(byte[] imageBytes, String mimeType);
}
