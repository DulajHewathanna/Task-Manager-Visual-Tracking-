package com.example.mobilecw.utils;

/**
 * A utility class for storing application constants.
 */
public class Constants {

    // Base URL of the API
    public static final String BASE_URL = "https://api.example.com/";

    // Timeout durations for network requests (in seconds)
    public static final int NETWORK_TIMEOUT = 30;

    // Intent extra keys
    public static final String EXTRA_PROJECT_ID = "EXTRA_PROJECT_ID";
    public static final String EXTRA_TASK_ID = "EXTRA_TASK_ID";

    // API Endpoints
    public static final String ENDPOINT_PROJECTS = "projects";
    public static final String ENDPOINT_TASKS = "tasks";
    public static final String ENDPOINT_MILESTONES = "milestones";

    // Shared Preferences keys
    public static final String PREFS_NAME = "TaskProjectManagerPrefs";
    public static final String PREF_USER_TOKEN = "PREF_USER_TOKEN";

    // Error messages
    public static final String ERROR_NETWORK = "Network error. Please try again.";
    public static final String ERROR_API = "Something went wrong. Please try again.";
    public static final String ERROR_UNAUTHORIZED = "Unauthorized access. Please log in.";

    // Date and time formats
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    // Debugging tags
    public static final String DEBUG_TAG_API = "API_DEBUG";
    public static final String DEBUG_TAG_NETWORK = "NETWORK_DEBUG";
}
