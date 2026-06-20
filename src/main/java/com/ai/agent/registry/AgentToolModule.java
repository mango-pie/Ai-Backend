package com.ai.agent.registry;

public abstract class AgentToolModule {

    public abstract String moduleName();

    protected abstract void registerTools(AgentToolRegistryBuilder registry);
}
