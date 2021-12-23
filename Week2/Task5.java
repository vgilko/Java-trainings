package Week2;

// Написать метод, который получает на вход массив элементов типа К (Generic)
// и возвращает Map<K, Integer>, где K — значение из массива, а Integer — количество вхождений в массив.
// То есть сигнатура метода выглядит так: <K> Map<K, Integer> arrayToMap(K[] ks);


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task5 {
    public static class ArrayProcessor {
        public static <K> Map<K, Integer> arrayToMap (K[] array) {
            HashMap<K, Integer> result = new HashMap<>();

            for (K value : array) {
                if (value != null) {
                    Integer amount = result.get(value);

                    if (amount == null) {
                        amount = 0;
                    }

                    result.put(value, amount + 1);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        final int ELEMENTS_AMOUNT = 10;
        final int CYCLES_AMOUNT = 3;
        final int RANDOM_BOUND = 5;

        Random random = new Random();

        for (int cycle = 0; cycle < CYCLES_AMOUNT; cycle++) {
            Integer[] array= new Integer[ELEMENTS_AMOUNT];

            for (int i = 0; i < ELEMENTS_AMOUNT; i++) {
                array[i] = random.nextInt(RANDOM_BOUND);
            }

            System.out.println(Arrays.toString(array));
            System.out.println(ArrayProcessor.arrayToMap(array));
            System.out.println("---------------");
        }
    }

}
