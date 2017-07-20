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

    // Operation names: Also need to be updated in corresponding handlers

    // Resource operations
    public static final String MSG_OP_RES_GET = "resource.get";
    public static final String MSG_OP_RES_CREATE = "resource.create";
    public static final String MSG_OP_RES_UPDATE = "resource.update";
    public static final String MSG_OP_RES_DELETE = "resource.delete";

    // Lookup Operations
    public static final String MSG_OP_LKUP_ACCESS_HAZARDS = "access.hazards";
    public static final String MSG_OP_LKUP_EDU_USE = "educational.use";
    public static final String MSG_OP_LKUP_READ_LEVEL = "reading.level";
    public static final String MSG_OP_LKUP_AD_STATUS = "ad.status";
    public static final String MSG_OP_LKUP_MEDIA_FEATURES = "media.features";
    public static final String MSG_OP_LKUP_GRADE = "grades";
    public static final String MSG_OP_LKUP_21_CEN_SKILLS = "21.cen.skills";
    public static final String MSG_OP_LKUP_AUDIENCE = "audience";
    public static final String MSG_OP_LKUP_MOMENTS = "moments";
    public static final String MSG_OP_LKUP_DOK = "dok";
    public static final String MSG_OP_LKUP_COUNTRIES = "countries";
    public static final String MSG_OP_LKUP_STATES = "states";
    public static final String MSG_OP_LKUP_SCHOOLDISTRICTS = "school-districts";
    public static final String MSG_OP_LKUP_SCHOOLS = "schools";
    public static final String MSG_OP_LKUP_LICENSES = "licenses";
    public static final String MSG_OP_LKUP_APIKEY_CONFIG = "apikey.config";

    // Assessment Operations
    public static final String MSG_OP_ASSESSMENT_GET = "assessment.get";
    public static final String MSG_OP_ASSESSMENT_CREATE = "assessment.create";
    public static final String MSG_OP_ASSESSMENT_UPDATE = "assessment.update";
    public static final String MSG_OP_ASSESSMENT_DELETE = "assessment.delete";
    public static final String MSG_OP_ASSESSMENT_COLLABORATOR_UPDATE = "assessment.collaborator.update";
    public static final String MSG_OP_ASSESSMENT_QUESTION_ADD = "assessment.question.add";
    public static final String MSG_OP_ASSESSMENT_QUESTION_REORDER = "assessment.content.reorder";
    // External Assessment Operations
    public static final String MSG_OP_EXT_ASSESSMENT_GET = "ext.assessment.get";
    public static final String MSG_OP_EXT_ASSESSMENT_CREATE = "ext.assessment.create";
    public static final String MSG_OP_EXT_ASSESSMENT_UPDATE = "ext.assessment.update";
    public static final String MSG_OP_EXT_ASSESSMENT_DELETE = "ext.assessment.delete";

    // Collection Operations
    public static final String MSG_OP_COLLECTION_GET = "collection.get";
    public static final String MSG_OP_COLLECTION_CREATE = "collection.create";
    public static final String MSG_OP_COLLECTION_UPDATE = "collection.update";
    public static final String MSG_OP_COLLECTION_DELETE = "collection.delete";
    public static final String MSG_OP_COLLECTION_COLLABORATOR_UPDATE = "collection.collaborator.update";
    public static final String MSG_OP_COLLECTION_QUESTION_ADD = "collection.question.add";
    public static final String MSG_OP_COLLECTION_CONTENT_REORDER = "collection.content.reorder";
    public static final String MSG_OP_COLLECTION_RESOURCE_ADD = "collection.resource.add";
    // Question Operations
    public static final String MSG_OP_QUESTION_GET = "question.get";
    public static final String MSG_OP_QUESTION_CREATE = "question.create";
    public static final String MSG_OP_QUESTION_UPDATE = "question.update";
    public static final String MSG_OP_QUESTION_DELETE = "question.delete";
    // Course Operations
    public static final String MSG_OP_COURSE_GET = "course.get";
      
    public static final String MSG_OP_COURSE_CREATE = "course.create";    
    public static final String MSG_OP_COURSE_UPDATE = "course.update";
    public static final String MSG_OP_COURSE_DELETE = "course.delete";
    public static final String MSG_OP_COURSE_COLLABORATOR_UPDATE = "course.collaborator.update";
    public static final String MSG_OP_COURSE_CONTENT_REORDER = "course.content.reorder";
    public static final String MSG_OP_COURSE_MOVE_UNIT = "course.move.unit";
    public static final String MSG_OP_COURSE_REORDER = "course.reorder";
    public static final String MSG_OP_UNIT_GET = "unit.get";
    public static final String MSG_OP_UNIT_CREATE = "unit.create";
    public static final String MSG_OP_UNIT_UPDATE = "unit.update";
    public static final String MSG_OP_UNIT_DELETE = "unit.delete";
    public static final String MSG_OP_UNIT_CONTENT_REORDER = "unit.content.reorder";
    public static final String MSG_OP_UNIT_MOVE_LESSON = "unit.move.lesson";
    public static final String MSG_OP_LESSON_GET = "lesson.get";
    public static final String MSG_OP_LESSON_CREATE = "lesson.create";
    public static final String MSG_OP_LESSON_UPDATE = "lesson.update";
    public static final String MSG_OP_LESSON_DELETE = "lesson.delete";
    public static final String MSG_OP_LESSON_CONTENT_REORDER = "lesson.content.reorder";
    public static final String MSG_OP_LESSON_MOVE_COLLECTION = "lesson.move.collection";
    public static final String MSG_OP_LESSON_REMOVE_COLLECTION = "lesson.remove.collection";

    // Taxonomy Lookup Operations

    // Operation names: Also need to be updated in corresponding handlers
    public static final String MSG_OP_TAXONOMY_SUBJECTS_GET = "taxonomy.subjects.get";
    public static final String MSG_OP_TAXONOMY_COURSES_GET = "taxonomy.courses.get";
    public static final String MSG_OP_TAXONOMY_DOMAINS_GET = "taxonomy.domains.get";
    public static final String MSG_OP_TAXONOMY_DOMAIN_CODES_GET = "taxonomy.domain.codes.get";
    public static final String MSG_OP_TAXONOMY_CODES_GET = "taxonomy.codes.get";

    // Class operations
    public static final String MSG_OP_CLASS_CREATE = "class.create";
    public static final String MSG_OP_CLASS_UPDATE = "class.update";
    public static final String MSG_OP_CLASS_DELETE = "class.delete";
    public static final String MSG_OP_CLASS_GET = "class.get";
    public static final String MSG_OP_CLASS_MEMBERS_GET = "class.members.get";
    public static final String MSG_OP_CLASS_COLLABORATORS_UPDATE = "class.collaborators.update";
    public static final String MSG_OP_CLASS_LIST = "class.list";
    public static final String MSG_OP_CLASS_LIST_FOR_COURSE = "class.list.for.course";
    public static final String MSG_OP_CLASS_JOIN = "class.join";
    public static final String MSG_OP_CLASS_INVITE = "class.invite.user";
    public static final String MSG_OP_CLASS_COURSE_ASSOCIATION = "class.course.association";
    public static final String MSG_OP_CLASS_SET_CONTENT_VISIBILITY = "class.content.visibility.set";
    public static final String MSG_OP_CLASS_GET_CONTENT_VISIBILITY_STATS = "class.content.visibility.stats.get";
    public static final String MSG_OP_CLASS_GET_CONTENT_VISIBILITY = "class.content.visibility.get";
    public static final String MSG_OP_CLASS_INVITE_REMOVE = "class.invite.user.remove";
    public static final String MSG_OP_CLASS_REMOVE_STUDENT = "class.join.removal";

    // Copier Operations
    public static final String MSG_OP_RESOURCE_COPY = "resource.copy";
    public static final String MSG_OP_QUESTION_COPY = "question.copy";
    public static final String MSG_OP_COLLECTION_COPY = "collection.copy";
    public static final String MSG_OP_ASSESSMENT_COPY = "assessment.copy";
    public static final String MSG_OP_COURSE_COPY = "course.copy";
    public static final String MSG_OP_UNIT_COPY = "unit.copy";
    public static final String MSG_OP_LESSON_COPY = "lesson.copy";

    // Profile Operations
    public static final String MSG_OP_PROFILE_COURSE_LIST = "profile.course.list";
    public static final String MSG_OP_PROFILE_COLLECTION_LIST = "profile.collection.list";
    public static final String MSG_OP_PROFILE_ASSESSMENT_LIST = "profile.assessment.list";
    public static final String MSG_OP_PROFILE_RESOURCE_LIST = "profile.resource.list";
    public static final String MSG_OP_PROFILE_QUESTION_LIST = "profile.question.list";
    public static final String MSG_OP_PROFILE_DEMOGRAPHICS_GET = "profile.demographics.get";
    public static final String MSG_OP_PROFILE_FOLLOW = "profile.follow";
    public static final String MSG_OP_PROFILE_UNFOLLOW = "profile.unfollow";
    public static final String MSG_OP_PROFILE_NETWORK_GET = "profile.network.get";
    public static final String MSG_OP_PROFILE_COURSE_SUBJECTBUCKETS_GET = "profile.course.subjectbucket.get";
    public static final String MSG_OP_PROFILE_COLLECTION_TAXONOMY_GET = "profile.collection.taxonomy.get";
    public static final String MSG_OP_PROFILE_ASSESSMENT_TAXONOMY_GET = "profile.assessment.taxonomy.get";
    public static final String MSG_OP_PROFILE_RESOURCE_TAXONOMY_GET = "profile.resource.taxonomy.get";
    public static final String MSG_OP_PROFILE_QUESTION_TAXONOMY_GET = "profile.question.taxonomy.get";

    // Event Operations
    public static final String MSG_OP_EVENT_PUBLISH = "event.publish";
    public static final String MSG_OP_EVENT_PROCESS = "event.process";

    // Class Reports Constants (Write)
    public static final String MSG_OP_PROCESS_PLAY_EVENTS = "process.play.events";
    public final static String MSG_OP_CREATE_EVENT = "create.event";
    public final static String MSG_OP_FIND_EVENT = "find.event";
      
    
    private MessageConstants() {
        throw new AssertionError();
    }
}
