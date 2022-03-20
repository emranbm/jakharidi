package ir.whentomeet.backend.utils;

import java.util.Random;

public class StringUtils {
    private static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int len) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            stringBuilder.append(CHARS.charAt(random.nextInt(CHARS.length())));
        return stringBuilder.toString();
    }
}
