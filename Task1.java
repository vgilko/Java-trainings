// 1.1 Заполнить массив случайным числами и вывести максимальное, минимальное и среднее значение.
// 1.2. Реализовать сортировку пузырьком.

import java.util.Scanner;
import java.util.Random;



public class Task1 {
    final static int max_value = 10;

    public static int[] generateRandomArray(int elementsAmount) {
        int[] arr = new int[elementsAmount];
        
        Random rand = new Random();
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(max_value);
        }

        return arr;
    }


    public static int find_min(int[] array) throws RuntimeException {
        if (array.length == 0) {
            throw new RuntimeException("Передан пустой массив");
        }
        int min_idx = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[min_idx] > array[i]) {
                min_idx = i;
            }
        }

        return array[min_idx];
    }

    public static int find_max(int[] array) throws RuntimeException {
        if (array.length == 0) {
            throw new RuntimeException("Передан пустой массив");
        }

        int max_idx = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[max_idx] < array[i]) {
                max_idx = i;
            }
        }

        return array[max_idx];
    }

    public static double find_average(int[] array) throws RuntimeException {
        if (array.length == 0) {
            throw new RuntimeException("Передан пустой массив");
        }

        double sum = 0;

        for (int value : array) {
            sum += value;
        }

        return sum / array.length;
    }

     /** Ищет в массиве максимум, минимум, среднее и выводит их в System.out
     */
    public static void process_array(int[] array) throws RuntimeException {
        if (array.length == 0) {
            throw new RuntimeException("Передан пустой массив");
        }

        int min_idx = 0, max_idx = 0;
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[min_idx] > array[i]) {
                min_idx = i;
            }

            if (array[max_idx] < array[i]) {
                max_idx = i;
            }

            sum += array[i];
        }

        double average = sum / array.length;

        System.out.printf("Значение максимального элемента: %d\n", array[max_idx]);
        System.out.printf("Значение минмального элемента: %d\n", array[min_idx]);
        System.out.printf("Среднее значение: %f\n", average);
        
    }


    public static void print_array(int[] array) {
        for (int value : array) {
            System.out.print(value);
            System.out.print(" ");
        }

        System.out.println();
    }

    


    public static int[] bubbleSort(int [] arr) {
        for (int idx_i = 0; idx_i < arr.length; idx_i++) {
            for (int idx_j = 0; idx_j < arr.length - 1; idx_j++) {
                if (arr[idx_j] > arr[idx_j + 1]) {
                    int temp = arr[idx_j + 1];
                    arr[idx_j + 1] = arr[idx_j];
                    arr[idx_j] = temp;
                }
            }

        }

        return arr;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов в массиве: ");

        int[] arr = generateRandomArray(scanner.nextInt());
        System.out.println("\nСгенерированный массив:");
        print_array(arr);

        System.out.println("Данные по массиву:");
        process_array(arr);

        System.out.println("\nОтсортироанный массив: ");
        arr = bubbleSort(arr);
        print_array(arr);

        scanner.close();
    }
}   