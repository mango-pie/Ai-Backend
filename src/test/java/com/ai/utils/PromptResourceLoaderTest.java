package com.ai.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromptResourceLoaderTest {

    @Test
    void loadDefaultPrompt_containsChinese() {
        String prompt = PromptResourceLoader.load("prompt/default-prompt.txt");
        assertTrue(prompt.contains("人工智能助手"));
        assertFalse(prompt.contains("浣犳"));
    }
}
