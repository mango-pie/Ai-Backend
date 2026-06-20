package com.ai.constant;

/**
 * 学习模块常量
 */
public interface StudyConstant {

    String INBOX_NAME = "收集箱";

    int LIST_TYPE_NORMAL = 0;
    int LIST_TYPE_INBOX = 1;

    int TASK_STATUS_PENDING = 0;
    int TASK_STATUS_DONE = 1;
    int TASK_STATUS_ABANDONED = 2;

    int FOCUS_STATUS_RUNNING = 0;
    int FOCUS_STATUS_COMPLETED = 1;
    int FOCUS_STATUS_ABANDONED = 2;
    int FOCUS_STATUS_PAUSED = 3;

    int FOCUS_TYPE_WORK = 0;
    int FOCUS_TYPE_SHORT_BREAK = 1;
    int FOCUS_TYPE_LONG_BREAK = 2;

    int SOURCE_TYPE_MANUAL = 0;
    int SOURCE_TYPE_BLOG_DRAFT = 1;

    int DEFAULT_PLANNED_MINUTES = 25;

    long TODAY_STATS_TTL_SECONDS = 300;
    long LISTS_TTL_SECONDS = 600;
    long INIT_LOCK_TTL_SECONDS = 30;

    String REDIS_PREFIX = "study:";
    String KEY_TODAY_STATS = "today_stats";
    String KEY_LISTS = "lists";
    String KEY_ACTIVE_FOCUS = "active_focus";
    String KEY_INIT_LOCK = "init_lock";

    static String redisKey(Long userId, String suffix) {
        return REDIS_PREFIX + userId + ":" + suffix;
    }

    enum StudyView {
        TODAY("today"),
        WEEK("week"),
        INBOX("inbox"),
        COMPLETED("completed"),
        LIST("list");

        private final String value;

        StudyView(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static StudyView fromValue(String value) {
            if (value == null) {
                return null;
            }
            for (StudyView view : values()) {
                if (view.value.equalsIgnoreCase(value)) {
                    return view;
                }
            }
            return null;
        }
    }
}
