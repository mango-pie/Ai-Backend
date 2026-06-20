package com.ai.agent;

import cn.hutool.core.util.StrUtil;

public enum ChatMode {

    ASK("ask"),
    AGENT("agent");

    private final String value;

    ChatMode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ChatMode from(String raw) {
        if (StrUtil.isBlank(raw)) {
            return ASK;
        }
        for (ChatMode mode : values()) {
            if (mode.value.equalsIgnoreCase(raw.trim())) {
                return mode;
            }
        }
        return ASK;
    }
}
