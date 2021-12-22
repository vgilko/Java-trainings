package Week1;

import java.util.Arrays;
import java.util.Random;

public class MyArray {
    private int[] array;

    private int min,
                max,
                sumElements;
    private double average;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public double getAverage() {
        return average;
    }

    private void fillArray() {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt();
        }
    }

    MyArray(int elementsAmount) throws IllegalArgumentException {
        if (elementsAmount <= 0) {
            throw new IllegalArgumentException("Количество элементов в массиве не может быть меньше 0");
        }

        array = new int[elementsAmount];
        sumElements = 0;

        fillArray();
        processArray();
    }

    private void updateMin(int value) {
        if (value < min) {
            min = value;
        }
    }

    private void updateMax(int value) {
        if (value > max) {
            max = value;
        }
    }
    
    private void calculateAverage() {
        if (array.length > 0) {
            average = sumElements / array.length;
        }
    }
    
    private void processArray() {
        for (int value : array) {
            updateMin(value);
            updateMax(value);
            sumElements += value;
        }

        calculateAverage();
    }

    public void printArray() {
        System.out.println(Arrays.toString(array));
    }


}
