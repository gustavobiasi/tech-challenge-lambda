package helloworld.utils;

public class Strings {

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isNonEmpty(String value) {
        return value != null && !value.isEmpty();
    }
}
