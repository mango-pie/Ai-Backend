package com.ai.agent.context;

import com.ai.agent.model.AgentToolContext;
import com.ai.exception.BusinessException;
import com.ai.exception.ErrorCode;

public final class AgentToolContextHolder {

    private static final ThreadLocal<AgentToolContext> CONTEXT = new ThreadLocal<>();

    private AgentToolContextHolder() {
    }

    public static void set(AgentToolContext context) {
        CONTEXT.set(context);
    }

    public static AgentToolContext get() {
        return CONTEXT.get();
    }

    public static Long requireUserId() {
        AgentToolContext context = CONTEXT.get();
        if (context == null || context.getUserId() == null) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "Agent 工具上下文缺失");
        }
        return context.getUserId();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
