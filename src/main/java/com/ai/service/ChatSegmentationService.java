package com.ai.service;

import java.util.List;

public interface ChatSegmentationService {

    /**
     * 将完整回复拆分为多条消息。失败、超时或不适合分段时返回单段原文。
     */
    List<String> segment(String text);
}
