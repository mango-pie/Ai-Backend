package com.ai.model.vo.chat;

import com.ai.agent.model.AgentUiAction;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ChatStreamEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String EVENT_CHUNK = "chunk";
    public static final String EVENT_SEGMENT_PLAN = "segment_plan";
    public static final String EVENT_DONE = "done";
    public static final String EVENT_TOOL_CALL = "tool_call";
    public static final String EVENT_TOOL_RESULT = "tool_result";
    public static final String EVENT_ERROR = "error";

    private String event;

    private String d;

    private String type;

    private List<String> segments;

    private List<Long> delays;

    private String tool;

    private Map<String, Object> args;

    private Integer step;

    private Boolean success;

    private Map<String, Object> data;

    private AgentUiAction uiAction;

    private String message;

    public static ChatStreamEvent chunk(String text, String type) {
        ChatStreamEvent event = new ChatStreamEvent();
        event.setEvent(EVENT_CHUNK);
        event.setD(text);
        event.setType(type);
        return event;
    }

    public static ChatStreamEvent segmentPlan(List<String> segments, List<Long> delays, String type) {
        ChatStreamEvent event = new ChatStreamEvent();
        event.setEvent(EVENT_SEGMENT_PLAN);
        event.setSegments(segments);
        event.setDelays(delays);
        event.setType(type);
        return event;
    }

    public static ChatStreamEvent done(String type) {
        ChatStreamEvent event = new ChatStreamEvent();
        event.setEvent(EVENT_DONE);
        event.setType(type);
        return event;
    }

    public static ChatStreamEvent toolCall(String tool, Map<String, Object> args, int step, String type) {
        ChatStreamEvent event = new ChatStreamEvent();
        event.setEvent(EVENT_TOOL_CALL);
        event.setTool(tool);
        event.setArgs(args);
        event.setStep(step);
        event.setType(type);
        return event;
    }

    public static ChatStreamEvent toolResult(String tool, boolean success, Map<String, Object> data,
                                             AgentUiAction uiAction, int step, String type) {
        ChatStreamEvent event = new ChatStreamEvent();
        event.setEvent(EVENT_TOOL_RESULT);
        event.setTool(tool);
        event.setSuccess(success);
        event.setData(data);
        event.setUiAction(uiAction);
        event.setStep(step);
        event.setType(type);
        return event;
    }

    public static ChatStreamEvent error(String message, String type) {
        ChatStreamEvent event = new ChatStreamEvent();
        event.setEvent(EVENT_ERROR);
        event.setMessage(message);
        event.setType(type);
        return event;
    }
}
