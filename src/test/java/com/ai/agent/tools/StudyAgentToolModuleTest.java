package com.ai.agent.tools;

import com.ai.agent.model.AgentToolContext;
import com.ai.agent.model.AgentToolResult;
import com.ai.model.dto.study.StudyTaskAddRequest;
import com.ai.model.entity.StudyList;
import com.ai.service.StudyListService;
import com.ai.service.StudyTaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class StudyAgentToolModuleTest {

    private StudyAgentToolModule module;
    private StudyTaskService studyTaskService;
    private StudyListService studyListService;

    @BeforeEach
    void setUp() {
        module = new StudyAgentToolModule();
        studyTaskService = mock(StudyTaskService.class);
        studyListService = mock(StudyListService.class);
        ReflectionTestUtils.setField(module, "studyTaskService", studyTaskService);
        ReflectionTestUtils.setField(module, "studyListService", studyListService);
    }

    @Test
    void createStudyTask_usesInboxWhenListIdMissing() {
        StudyList inbox = new StudyList();
        inbox.setId(99L);
        when(studyListService.getOrCreateInbox(1L)).thenReturn(inbox);
        when(studyTaskService.addTask(any(StudyTaskAddRequest.class), eq(1L))).thenReturn(1001L);

        AgentToolContext ctx = AgentToolContext.builder().userId(1L).build();
        AgentToolResult result = invokeCreate(ctx, "{\"title\":\"写大纲\",\"isToday\":true}");

        assertTrue(result.isSuccess());
        assertEquals(1001L, result.getData().get("taskId"));
        verify(studyTaskService).addTask(any(StudyTaskAddRequest.class), eq(1L));
    }

    private AgentToolResult invokeCreate(AgentToolContext ctx, String args) {
        com.ai.agent.registry.AgentToolRegistryBuilder builder =
                new com.ai.agent.registry.AgentToolRegistryBuilder("study");
        module.registerTools(builder);
        return builder.buildDefinitions().stream()
                .filter(def -> "create_study_task".equals(def.name()))
                .findFirst()
                .orElseThrow()
                .executor()
                .apply(ctx, args);
    }
}
