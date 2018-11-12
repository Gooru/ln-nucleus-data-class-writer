package org.gooru.nucleus.insights.events.gateway.constants;

/**
 * Created by ashish on 4/12/15
 * updated by mukul@gooru for Class Reports
 * 
 */
public final class RouteConstants {

    // Helper: Entity Id constants
    public static final String ID_RESOURCE = "resourceId";
    public static final String ID_QUESTION = "questionId";
    public static final String ID_ASSESSMENT = "assessmentId";
    public static final String ID_COLLECTION = "collectionId";
    public static final String ID_COURSE = "courseId";
    public static final String ID_UNIT = "unitId";
    public static final String ID_LESSON = "lessonId";
    public static final String ID_CLASS = "classId";
    public static final String ID_TX_SUBJECT = "subjectId";
    public static final String ID_TX_DOMAIN = "domainId";
    public static final String ID_TX_COURSE = "courseId";
    public static final String ID_TX_STANDARD_FRAMEWORK = "standardFrameworkId";
    public static final String ID_TX_CODE_ID_LIST = "idList";
    public static final String ID_COUNTRY = "countryId";
    public static final String ID_USER = "userId";
    public static final String ID_EMAIL = "email";
    public static final String CODE_CLASS = "classCode";
    public static final String ID_SESSION = "sessionId";

    private static final String SEP = "/";
    private static final String COLON = ":";

    //Class Reports
    private static final String LOCATION = "location";
    private static final String CURRENT = "current";
    private static final String PERFORMANCE = "performance";
    
    // Helper constants
	public static final String API_AUTH_ROUTE = "/api/nucleus-insights/*";
    //Updated API Version
    private static final String API_VERSION = "v2";
    private static final String API_BASE_ROUTE = "/api/nucleus-insights/" + API_VERSION + '/';
    
    //Route Analytics Events - Class Reports
    private static final String EVENT = "event";
    public static final String WRITE_EVENT_ROUTE = API_BASE_ROUTE + EVENT;
    
    //For connecting to Cassandra Analytics
    public static final String API_KEY = "?apiKey=c2hlZWJhbkBnb29ydWxlYXJuaW5nLm9yZw==";
    public static final String CASS_WRITE_EVENT_ROUTE = API_BASE_ROUTE + EVENT + API_KEY;

    //Rubric Grading
    private static final String ENTITY_STUDENTS = "students";
    private static final String ENTITY_GRADES = "grades";
    private static final String ENTITY_RUBRICS = "rubrics";
    private static final String ENTITY_SELF_REPORT = "self-report";
    private static final String ENTITY_OFFLINE_REPORT = "offline-report";
    
    //POST: {REST_END_POINT}/api/nucleus-insights/v2/rubrics/grades
    public static final String STUDENT_GRADES_POST = API_BASE_ROUTE + ENTITY_RUBRICS + SEP + ENTITY_GRADES;

    //Teacher Override for Score
    //POST: {REST_END_POINT}/api/nucleus-insights/v2/score
    private static final String SCORE = "score";
    public static final String UPDATE_SCORE_ROUTE = API_BASE_ROUTE + SCORE;

    //POST: {REST_END_POINT}/api/nucleus-insights/v2/self-report
    public static final String STUDENT_SELF_GRADE_EXT_ASSESSMENT_POST = API_BASE_ROUTE + ENTITY_SELF_REPORT;

    
    public static final String EP_INTERNAL_BANNER = "/api/internal/v1/banner";
    public static final String EP_INTERNAL_METRICS = "/api/internal/v1/metrics";
    // This is event publisher. It expects full blown event structure which will be relayed to Kafka
    public static final String EP_INTERNAL_EVENT = "/api/internal/v1/events";
    // This is event processor. It provides a JSON Object as request which has two parts.
    // One mandatory part is <event> this is processed as other events from the message bus
    // Second optional part is <context> which can provide additional information like email should be sent or not
    // Note that difference between original message on message bus and this is the presence of op name
    public static final String EP_INTERNAL_EVENT_PROCESSOR = "/api/internal/v1/eventprocessor";
    
    //POST: {REST_END_POINT}/api/nucleus-insights/v2/offline-report
    public static final String OFFLINE_REPORT_POST = API_BASE_ROUTE + ENTITY_OFFLINE_REPORT;

    private RouteConstants() {
        throw new AssertionError();
    }

}
