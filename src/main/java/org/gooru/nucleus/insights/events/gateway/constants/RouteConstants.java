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

    // Helper: Operations
    private static final String OP_ORDER = "order";
    private static final String OP_LOOKUP = "lookups";
    private static final String OP_MEMBER = "members";
    private static final String OP_INVITE = "invites";
    private static final String OP_AUTH = "authorization";
    private static final String OP_DEMOGRAPHICS = "demographics";
    private static final String OP_FOLLOW = "follow";
    private static final String OP_UNFOLLOW = "unfollow";
    private static final String OP_SUBJECT_BUCKET = "subject-buckets";
    private static final String OP_TAXONOMY = "taxonomy";
    private static final String OP_NETWORK = "network";

    // Misc helpers
    private static final String RES_EDUCATIONAL_USE = "educational-use";
    private static final String RES_DOK = "dok";
    private static final String RES_ACCESS_HAZARDS = "access-hazards";
    private static final String RES_READING_LEVELS = "reading-levels";
    private static final String RES_ADS = "ads";
    private static final String RES_MEDIA_FEATURES = "media-features";
    private static final String RES_CEN21SKILLS = "21-century-skills";
    private static final String RES_GRADES = "grades";
    private static final String RES_MOMENTS = "moments";
    private static final String RES_AUDIENCE = "audience";
    private static final String RES_COUNTRIES = "countries";
    private static final String RES_STATES = "states";
    private static final String RES_SCHOOLDISTRICTS = "school-districts";
    private static final String RES_SCHOOLS = "schools";
    private static final String RES_TX_STANDARD_FRAMEWORK = "frameworks";
    private static final String RES_LICENSE = "licenses";
    private static final String RES_APIKEY_CONFIG = "apikey-config";
    private static final String RES_STATS = "stats";
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
    private static final String API_RUBRIC_ROUTE = "/api/rubric-grading/" + API_VERSION + '/';
    
    // Helper: Entity name constants
    private static final String ENTITY_RESOURCES = "resources";
    private static final String ENTITY_QUESTIONS = "questions";
    private static final String ENTITY_ASSESSMENTS = "assessments";
    
    private static final String ENTITY_ASSESSMENT = "assessment";    
    private static final String ENTITY_ASSESSMENTS_EX = "assessments-external";
    private static final String ENTITY_COLLECTIONS = "collections";
    
    private static final String ENTITY_COLLECTION = "collections";
    private static final String ENTITY_COURSES = "courses";
    private static final String ENTITY_UNITS = "units";
    private static final String ENTITY_LESSONS = "lessons";
    private static final String ENTITY_CLASSES = "classes";
    private static final String ENTITY_COLLABORATORS = "collaborators";
    private static final String ENTITY_TAXONOMY = "taxonomy";
    private static final String ENTITY_TX_SUBJECT = "subjects";
    private static final String ENTITY_TX_COURSE = "courses";
    private static final String ENTITY_TX_DOMAIN = "domains";
    private static final String ENTITY_TX_CODES = "codes";
    private static final String ENTITY_COPIER = "copier";
    private static final String ENTITY_PROFILES = "profiles";

    private static final String ENTITY_PEERS = "peers";
    private static final String ENTITY_USER = "user";
    private static final String ENTITY_SESSION = "sessions";
    private static final String ENTITY_STATUS = "status";

    
    //Route Analytics Events - Class Reports
    private static final String EVENT = "event";
    public static final String WRITE_EVENT_ROUTE = API_BASE_ROUTE + EVENT;
    
    //Mukul - For connecting to Cassandra Analytics
    public static final String API_KEY = "?apiKey=c2hlZWJhbkBnb29ydWxlYXJuaW5nLm9yZw==";
    public static final String CASS_WRITE_EVENT_ROUTE = API_BASE_ROUTE + EVENT + API_KEY;
    
    //Rubric Grading
    private static final String ENTITY_STUDENTS = "students";
    private static final String ENTITY_GRADES = "grades";
    
    //POST: {REST_END_POINT}/api/rubric-grading/v2/students/grades
    public static final String STUDENT_GRADES_POST = API_RUBRIC_ROUTE + ENTITY_STUDENTS + SEP + ENTITY_GRADES;

    public static final String EP_INTERNAL_BANNER = "/api/internal/v1/banner";
    public static final String EP_INTERNAL_METRICS = "/api/internal/v1/metrics";
    // This is event publisher. It expects full blown event structure which will be relayed to Kafka
    public static final String EP_INTERNAL_EVENT = "/api/internal/v1/events";
    // This is event processor. It provides a JSON Object as request which has two parts.
    // One mandatory part is <event> this is processed as other events from the message bus
    // Second optional part is <context> which can provide additional information like email should be sent or not
    // Note that difference between original message on message bus and this is the presence of op name
    public static final String EP_INTERNAL_EVENT_PROCESSOR = "/api/internal/v1/eventprocessor";

    private RouteConstants() {
        throw new AssertionError();
    }

}
