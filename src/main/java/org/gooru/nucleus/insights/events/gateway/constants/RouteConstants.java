package org.gooru.nucleus.insights.events.gateway.constants;

/**
 * Created by ashish on 4/12/15
 * updated by mukul@gooru for Class Reports
 * 
 */
public final class RouteConstants {

	private static final String SEP = "/";
    private static final String COLON = ":";
    
    // Helper constants
	public static final String API_AUTH_ROUTE = "/api/nucleus-insights/*";
    //Updated API Version
    private static final String API_VERSION = "v2";
    private static final String API_BASE_ROUTE = "/api/nucleus-insights/" + API_VERSION + '/';
    private static final String API_INTERNAL_ROUTE = "/api/internal/nucleus-insights/";
    		
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
    private static final String ENTITY_COLLECTIONS = "collections";
    //Offline Activities
    private static final String ENTITY_SUBMISSIONS = "submissions";
    private static final String ENTITY_OA = "oa";
    private static final String ENTITY_SELF_GRADE = "self-grade";
    private static final String ENTITY_COMPLETE = "complete";
    
    //POST: {REST_END_POINT}/api/nucleus-insights/v2/rubrics/grades
    public static final String STUDENT_GRADES_POST = API_BASE_ROUTE + ENTITY_RUBRICS + SEP + ENTITY_GRADES;

    //Teacher Override for Score
    //POST: {REST_END_POINT}/api/nucleus-insights/v2/score
    private static final String SCORE = "score";
    private static final String PERFORMANCE_UPDATE = "perf-update";
    public static final String UPDATE_SCORE_ROUTE = API_BASE_ROUTE + SCORE;
    public static final String UPDATE_PERFORMANCE_ROUTE = API_BASE_ROUTE + PERFORMANCE_UPDATE;

    //POST: {REST_END_POINT}/api/nucleus-insights/v2/self-report
    public static final String STUDENT_SELF_GRADE_EXT_ASSESSMENT_POST = API_BASE_ROUTE + ENTITY_SELF_REPORT;
    
    //POST: {REST_END_POINT}/api/nucleus-insights/v2/offline-report
    public static final String OFFLINE_REPORT_POST = API_BASE_ROUTE + ENTITY_OFFLINE_REPORT;

    //Offline Activities
    //POST: {REST_END_POINT}/api/nucleus-insights/v2/oa/evidences
    public static final String OA_SUBMISSIONS_POST = API_BASE_ROUTE + ENTITY_OA + 
    		SEP + ENTITY_SUBMISSIONS;
    //POST: {REST_END_POINT}/api/nucleus-insights/self-grade    
    public static final String OA_STUDENT_SELF_GRADING_POST = API_BASE_ROUTE + ENTITY_SELF_GRADE;
    //POST: {REST_END_POINT}/api/nucleus-insights/oa/grades
    public static final String OA_TEACHER_GRADING_POST = API_BASE_ROUTE + ENTITY_OA + 
    		SEP + ENTITY_GRADES;
    //POST: internal/nucleus-insights/oa/complete (Internal API)
    public static final String INTERNAL_OA_COMPLETE_POST = API_INTERNAL_ROUTE + ENTITY_OA + 
    		SEP + ENTITY_COMPLETE;
    
    //GRADING - for Collections, currently supported for OA.
    //TODO: reconcile this API with earlier STUDENT_GRADES_POST API, in coordination with FrontEnd
    public static final String COLLECTION_RUBRICS_GRADING_POST = API_BASE_ROUTE + ENTITY_RUBRICS + 
    		SEP + ENTITY_GRADES + SEP + ENTITY_COLLECTIONS;
    
    private RouteConstants() {
        throw new AssertionError();
    }

}
