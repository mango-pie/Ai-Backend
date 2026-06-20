package com.ai.utils;

import com.ai.exception.BusinessException;
import com.ai.exception.ErrorCode;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 以 UTF-8 加载 classpath 提示词，避免 Windows 默认 GBK 导致乱码。
 */
public final class PromptResourceLoader {

    private PromptResourceLoader() {
    }

    public static String load(String classpathResource) {
        String path = classpathResource.startsWith("/") ? classpathResource.substring(1) : classpathResource;
        try (InputStream in = PromptResourceLoader.class.getClassLoader().getResourceAsStream(path)) {
            if (in == null) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "提示词文件不存在: " + classpathResource);
            }
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "读取提示词失败: " + classpathResource);
        }
    }
}
