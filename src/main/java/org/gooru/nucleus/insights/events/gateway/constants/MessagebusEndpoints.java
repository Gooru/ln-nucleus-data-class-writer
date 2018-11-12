package org.gooru.nucleus.insights.events.gateway.constants;

public final class MessagebusEndpoints {

    //Class Reports API - Write
    public static final String MBEP_ANALYTICS_WRITE = "org.gooru.nucleus.message.bus.analytics.write";
    //Update Event - Teacher Override for Score
    public static final String MBEP_ANALYTICS_UPDATE = "org.gooru.nucleus.message.bus.analytics.update";
    public static final String MBEP_RAW_EVENT = "org.gooru.nucleus.insights.message.bus.event";
    
    //Student Self Grading 
    public static final String MBEP_ANALYTICS_SELF_GRADING_EXT_ASSESSMENT = "org.gooru.nucleus.message.bus.analytics.self.grade.ext.assessment";
    //Student Offline Report 
    public static final String MBEP_ANALYTICS_OFFLINE_REPORT = "org.gooru.nucleus.message.bus.analytics.offline.report";
    
    private MessagebusEndpoints() {
        throw new AssertionError();
    }
}
