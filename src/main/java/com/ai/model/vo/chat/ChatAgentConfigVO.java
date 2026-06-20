package com.ai.model.vo.chat;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ChatAgentConfigVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String defaultMode = "ask";

    private boolean agentEnabled;

    private String agentHint;

    private List<String> modules;

    private List<String> toolNames;
}
