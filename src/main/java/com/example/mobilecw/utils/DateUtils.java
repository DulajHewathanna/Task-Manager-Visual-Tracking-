package com.example.mobilecw.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A utility class for handling date and time operations.
 */
public class DateUtils {

    // Default date and time formats
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * Formats a Date object into a string with the specified format.
     *
     * @param date   The Date object to format.
     * @param format The desired date format.
     * @return A formatted date string, or null if the input date is null.
     */
    public static String formatDate(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        return sdf.format(date);
    }

    /**
     * Parses a date string into a Date object with the specified format.
     *
     * @param dateString The date string to parse.
     * @param format     The expected format of the date string.
     * @return A Date object, or null if parsing fails.
     */
    public static Date parseDate(String dateString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets the current date and time as a formatted string.
     *
     * @param format The desired date format.
     * @return A string representing the current date and time.
     */
    public static String getCurrentDateTime(String format) {
        Date now = new Date();
        return formatDate(now, format);
    }

    /**
     * Converts a date string from one format to another.
     *
     * @param dateString      The date string to convert.
     * @param fromFormat      The current format of the date string.
     * @param toFormat        The desired format of the date string.
     * @return A string in the new format, or null if conversion fails.
     */
    public static String convertDateFormat(String dateString, String fromFormat, String toFormat) {
        Date date = parseDate(dateString, fromFormat);
        if (date != null) {
            return formatDate(date, toFormat);
        }
        return null;
    }

    /**
     * Checks if a date string is valid for the given format.
     *
     * @param dateString The date string to validate.
     * @param format     The expected format of the date string.
     * @return True if the date string is valid, false otherwise.
     */
    public static boolean isValidDate(String dateString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        sdf.setLenient(false);
        try {
            sdf.parse(dateString);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
