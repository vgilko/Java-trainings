package Week2;

// Написать программу, которая объединяет две коллекции Map.

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Task6 {
    public static class MapUnion {
        public static <Type1, Type2> Map<Type1, Type2> mapUnion (Map<Type1, Type2> first, Map<Type1, Type2> second) {
            HashMap<Type1, Type2> result = new java.util.HashMap<>(Map.copyOf(first));
            result.putAll(second);

            return result;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        final int KEYS_AMOUNT = 5;
        final int CYCLES_AMOUNT = 5;

        for (int cycle = 0; cycle < CYCLES_AMOUNT; cycle++) {
            HashMap<Integer,Integer> testMapFirst = new HashMap<>();
            HashMap<Integer,Integer> testMapSecond = new HashMap<>();

            for (int i = 0; i < KEYS_AMOUNT; i++) {
                testMapFirst.put(random.nextInt(10), random.nextInt(1));
                testMapSecond.put(random.nextInt(10), random.nextInt(1));
            }

            System.out.println(testMapFirst.keySet());
            System.out.println(testMapSecond.keySet());

            System.out.printf("result = %s\n", MapUnion.mapUnion(testMapFirst, testMapSecond).keySet().stream().sorted().collect(Collectors.toList()));
            System.out.println("---------");
        }
    }
}
