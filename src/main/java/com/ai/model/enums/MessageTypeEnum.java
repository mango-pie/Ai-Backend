package com.ai.model.enums;

import lombok.Getter;

/**
 * 消息类型枚举
 *
 * @author <a href="https://github.com/liyupi">scene</a>
 */
@Getter
public enum MessageTypeEnum {
    
    USER("user", "用户消息"),
    AI("ai", "AI消息"),
    ERROR("error", "错误消息");
    
    private final String value;
    private final String description;
    
    MessageTypeEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }
    
    /**
     * 根据值获取枚举
     *
     * @param value 值
     * @return 枚举
     */
    public static MessageTypeEnum getByValue(String value) {
        for (MessageTypeEnum enumValue : MessageTypeEnum.values()) {
            if (enumValue.getValue().equals(value)) {
                return enumValue;
            }
        }
        return null;
    }
}