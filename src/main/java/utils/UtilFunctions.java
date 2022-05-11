package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A collection of static, utility functions.
 */
public class UtilFunctions {

    /**
     * Capitalizes the first letter of a string.
     *
     * @param original the original string
     * @return the original string with the first letter capitalized
     */
    public static String capitalizeFirstLetter(String original) {
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

    /**
     * Validates a day string
     *
     * @param day - string to be validated
     * @return true if the string is a valid day, false otherwise
     */
    public static boolean isValidDay(String day) {
        day = day.toLowerCase();
        return day.equals("monday") || day.equals("tuesday") || day.equals("wednesday") || day.equals("thursday") || day.equals("friday");
    }

    /**
     * Validates a time string
     *
     * @param time - string to be validated
     * @return true if the string is a valid time, false otherwise
     */
    public static boolean isValidTime(String time) {
        Pattern pattern = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
        Matcher matcher = pattern.matcher(time);
        return matcher.matches();
    }

    /**
     * Validates a date string for the format dd-MM-yyyy
     *
     * @param date - string to be validated
     * @return true if the string is a valid date, false otherwise
     */
    public static boolean isValidDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
