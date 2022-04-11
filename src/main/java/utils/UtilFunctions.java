package utils;

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
}
