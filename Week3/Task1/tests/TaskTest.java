package Week3.Task1.tests;

import Week3.Task1.Human;
import Week3.Task1.sort.BubbleSort;
import Week3.Task1.sort.QuickSort;

import java.util.List;

import static Week3.Task1.tests.Generators.generateHumanList;

public class TaskTest {
    static void testFirstTask () {
        List<Human> list = generateHumanList(1000);
        List<Human> secondList = List.copyOf(list);
//        System.out.println("Первый");
//        list.forEach(System.out::println);
//        System.out.println("\n\nВторой");
//        secondList.forEach(System.out::println);

        BubbleSort bubbleSort = new BubbleSort();
        QuickSort quickSort = new QuickSort();


        System.out.println("\n\nПервый после сортировки:");
        long startTime = System.currentTimeMillis();
        quickSort.sort(list);
//        list.forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.printf("\n\nПотрачено времени: %f\n", (endTime - startTime) / 1000f);
        System.out.println("---------");

        System.out.println("Второй после сортировки:");
        startTime = System.currentTimeMillis();
        bubbleSort.sort(list);
//        list.forEach(System.out::println);
        endTime = System.currentTimeMillis();
        System.out.printf("\n\nПотрачено времени: %f\n", (endTime - startTime) / 1000f);
        System.out.println("---------");

    }

    public static void main(String[] args) {
        testFirstTask();
    }
}
