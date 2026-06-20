package com.ai.model.vo.chat;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * AstrBot 预设配置 VO（用于前端角色/人格选择列表）。
 * 字段尽量宽松以适配 AstrBot /api/v1/configs 返回的实际结构。
 */
@Data
public class ChatConfigVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 配置 id（AstrBot 侧用于区分预设/角色）
     */
    private String id;

    /**
     * 显示名称
     */
    private String name;

    /**
     * 描述（可选）
     */
    private String description;

    /**
     * 原始数据（如果 AstrBot 返回更多字段，前端或后端可直接使用）
     */
    private Map<String, Object> raw;
}