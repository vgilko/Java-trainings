package Week2;

// Написать метод fill, который принимает массив объектов, и реализацию интерфейса Function.
// Метод fill должен заполнить массив, получая новое значение по индексу с помощью реализации интерфейса Function.

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class Task7 {
    public static class ArrayFiller {
        public static <K> void fillArray (K[] array, Function<Integer, K> function) {
            for (int i = 0; i < array.length; i++) {
                array[i] = function.apply(i);
            }
        }
    }

    public static class ExampleClass {
        int index;

        public int getIndex() {
            return index;
        }

        ExampleClass (int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "ExampleClass{" +
                    "index=" + index +
                    '}';
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[10];
        ExampleClass[] classArray = new ExampleClass[10];

        Function<Integer, ExampleClass> createExample = (Integer index) -> {
            return new ExampleClass(index + 1);
        };

        ArrayFiller.fillArray(array, (Integer idx) -> {
            Random random = new Random ();
            return random.nextInt(100) * idx;
        });

        ArrayFiller.fillArray(classArray, createExample);

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(classArray));
    }

}
