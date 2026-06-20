package com.ai.model.enums;

import lombok.Getter;

@Getter
public enum ChatMessageSourceEnum {

    NORMAL("normal", "普通消息"),
    PROACTIVE("proactive", "主动消息"),
    AGENT("agent", "Agent 回复");

    private final String value;
    private final String description;

    ChatMessageSourceEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public static ChatMessageSourceEnum getByValue(String value) {
        if (value == null) {
            return NORMAL;
        }
        for (ChatMessageSourceEnum item : values()) {
            if (item.value.equals(value)) {
                return item;
            }
        }
        return NORMAL;
    }
}
