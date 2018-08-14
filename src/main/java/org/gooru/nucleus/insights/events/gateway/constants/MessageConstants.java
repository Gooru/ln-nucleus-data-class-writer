package org.gooru.nucleus.insights.events.gateway.constants;

public final class MessageConstants {

    public static final String MSG_HEADER_OP = "mb.operation";
    public static final String MSG_HEADER_TOKEN = "session.token";
    public static final String MSG_OP_AUTH_WITH_PREFS = "auth.with.prefs";
    public static final String MSG_OP_STATUS = "mb.operation.status";
    public static final String MSG_KEY_PREFS = "prefs";
    public static final String MSG_OP_STATUS_SUCCESS = "success";
    public static final String MSG_OP_STATUS_ERROR = "error";
    public static final String MSG_OP_STATUS_VALIDATION_ERROR = "error.validation";
    public static final String MSG_USER_ANONYMOUS = "anonymous";
    public static final String MSG_USER_ID = "user_id";
    public static final String MSG_HTTP_STATUS = "http.status";
    public static final String MSG_HTTP_BODY = "http.body";
    public static final String MSG_HTTP_RESPONSE = "http.response";
    public static final String MSG_HTTP_ERROR = "http.error";
    public static final String MSG_HTTP_VALIDATION_ERROR = "http.validation.error";
    public static final String MSG_HTTP_HEADERS = "http.headers";

    // Event Operations
    public static final String MSG_OP_EVENT_PUBLISH = "event.publish";
    public static final String MSG_OP_EVENT_PROCESS = "event.process";

    // Class Reports Constants (Write)
    public static final String MSG_OP_PROCESS_PLAY_EVENTS = "process.play.events";
    public final static String MSG_OP_CREATE_EVENT = "create.event";
    public final static String MSG_OP_FIND_EVENT = "find.event";
    //Update Event - Teacher Override for Score
    public final static String MSG_OP_UPDATE_EVENT = "update.event";
    //Student Self Grade for External Assessment
    public final static String MSG_OP_SELF_GRADE_EXT_ASSESSMENT = "student.self.grade.ext.assessment";
    
    private MessageConstants() {
        throw new AssertionError();
    }
}
