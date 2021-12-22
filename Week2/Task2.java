package Week2;

import java.util.HashMap;
import java.util.Map;

//Написать программу, которая проверяет, что заданная строка содержит только цифры.

public class Task2 {
    public static boolean isAllDigit (String input) {
        if (input == null || input.isEmpty())
            return false;

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)))
                return false;
        }

        return true;
    }

    public static void testIsAllDigit () {
        Map<String, Boolean> testToResult = Map.ofEntries(
                Map.entry("123ewrew12314324", false),
                Map.entry("123432423123;", false),
                Map.entry("12312314324", true),
                Map.entry("1", true),
                Map.entry("0", true),
                Map.entry("", false),
                Map.entry("-123", false),
                Map.entry("0000", true),
                Map.entry("q", false),
                Map.entry("qgfgdgdf", false),
                Map.entry(";123412", false),
                Map.entry(";1", false),
                Map.entry("1;", false),
                Map.entry("               ", false)
        );

        for (Map.Entry<String, Boolean> pair : testToResult.entrySet()) {
            boolean result = isAllDigit(pair.getKey());
//            assert result == pair.getValue().booleanValue();
            if (result != pair.getValue()) {
                throw new AssertionError(pair.getKey() + ": expected :" + pair.getValue() + ", result: " + result);
            }
        }
    }

    public static void main(String[] args) {
        testIsAllDigit();
    }
}
