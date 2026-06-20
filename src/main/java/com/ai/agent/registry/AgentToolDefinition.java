package com.ai.agent.registry;

import com.ai.agent.model.AgentToolContext;
import com.ai.agent.model.AgentToolLevel;
import com.ai.agent.model.AgentToolResult;
import dev.langchain4j.agent.tool.ToolSpecification;

import java.util.function.BiFunction;

public record AgentToolDefinition(
        String name,
        String description,
        AgentToolLevel level,
        String module,
        ToolSpecification specification,
        BiFunction<AgentToolContext, String, AgentToolResult> executor
) {
}
