package Week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

// Написать программу, которая отыскивает наибольший общий префикс, заданных строк.

public class Task1 {
    static class StringPrefix {
        public static String findMaxPrefix (String[] strings) {
            if (strings == null || strings.length == 0) {
                return "";
            } else if (strings.length == 1) {
                return  strings[0];
            }

            for (String string : strings) {
                if (string == null || string.isEmpty()) {
                    return "";
                }
            }

            Arrays.sort(strings);

            int index = findLastPrefixIndex(strings);

            return index == 0 ? "" : strings[0].substring(0, index);
        }

        private static int findLastPrefixIndex (String[] strings) {
            int i;
            for (i = 0; i < strings[0].length(); i++) {
                char currentChar = strings[0].charAt(i);
                for (int arrayIndex = 1; arrayIndex < strings.length; arrayIndex++) {
                    if (strings[arrayIndex].charAt(i) != currentChar)
                        return i;
                }
            }

            return i;
        }
    }

    public static void testFindMaxPrefix () {
        Map<String[], String> testToResult = Map.ofEntries(
                Map.entry(new String[] {"aa", "aasdf","aasdf"}, "aa"),
                Map.entry(new String[] {"aasdf", "aasdf","aasdf"}, "aasdf"),
                Map.entry(new String[] {"", "", null}, ""),
                Map.entry(new String[] {"", "aasdf","aasdf"}, ""),
                Map.entry(new String[] {"-=aasdf", "aasdf","aasdf"}, ""),
                Map.entry(new String[] {"aasdf", "aasdf"}, "aasdf"),
                Map.entry(new String[] {"\0\0\0", "\0\0\0"}, "\0\0\0"),
                Map.entry(new String[] {"   ", "   "}, "   "),
                Map.entry(new String[] {" 1 ", " 1 "}, " 1 "),
                Map.entry(new String[] {"1", "1"}, "1"),
                Map.entry(new String[] {"1b", "1d"}, "1")
        );

        for (Map.Entry<String[], String> pair : testToResult.entrySet()) {
            String result = StringPrefix.findMaxPrefix(pair.getKey());
            if (!result.equals(pair.getValue())) {
                throw new AssertionError(Arrays.toString(pair.getKey()) + ": expected :" + pair.getValue() + ", result: " + result);
            }
        }
    }


    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        testFindMaxPrefix();

//        try {
//            System.out.println("Введите первую строку: ");
//            String first = reader.readLine();
//            System.out.println("Введите вторую строку: ");
//            String second = reader.readLine();
//
//            System.out.printf("Наибольший префикс: %s\n", StringPrefix.findMaxPrefix(new String[] {first,second}));
//                System.out.println("-------------");
//        } catch (IOException e) {
//            System.out.println("Неккоректный ввод.");
//        }

    }
}
