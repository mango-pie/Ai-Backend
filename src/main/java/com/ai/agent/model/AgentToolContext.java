package com.ai.agent.model;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AgentToolContext {

    private Long userId;

    private Long conversationId;

    private String configId;

    private HttpServletRequest request;
}
