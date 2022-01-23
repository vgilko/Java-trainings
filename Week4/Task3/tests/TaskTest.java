package Week4.Task3.tests;

import Week4.Task3.interfaces.Sortable;
import Week4.Task3.sort.BubbleSort;
import Week4.Task3.Human;
import Week4.Task3.sort.QuickSort;

import java.util.ArrayList;
import java.util.List;

import static Week4.Task3.tests.Generators.generateHumanList;

public class TaskTest {
    static void testFirstTask () {
        List<Human> list = generateHumanList(10000);
        ArrayList<Human> secondList = new ArrayList<>(list);
//        System.out.println("Первый");
//        list.forEach(System.out::println);
//        System.out.println("\n\nВторой");
//        secondList.forEach(System.out::println);

        Sortable bubbleSort = BubbleSort.getInstance();
        Sortable quickSort = QuickSort.getInstance();


        System.out.println("\n\nПервый после сортировки:");
        long startTime = System.currentTimeMillis();
        quickSort.sort(list);
//        list.forEach(System.out::println);
        long endTime = System.currentTimeMillis();
        System.out.printf("\n\nПотрачено времени: %f\n", (endTime - startTime) / 1000f);
        System.out.println("---------");

        System.out.println("Второй после сортировки:");
        startTime = System.currentTimeMillis();
        bubbleSort.sort(secondList);
//        list.forEach(System.out::println);
        endTime = System.currentTimeMillis();
        System.out.printf("\n\nПотрачено времени: %f\n", (endTime - startTime) / 1000f);
        System.out.println("---------");

    }

    public static void main(String[] args) {
        testFirstTask();
    }
}
