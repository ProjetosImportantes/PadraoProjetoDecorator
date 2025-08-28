package org.example.decorator.util;

public final class TextUtils {
    private TextUtils() {}


    public static String sanitize(String input) {
        if (input == null) return "";
        return input.trim();
    }
}