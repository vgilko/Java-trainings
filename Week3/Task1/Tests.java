package Week3.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tests {
    static List<Human> generateHumanList (int amount) {
        List<Human> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            StringBuilder name = new StringBuilder();

            int nameLength = random.nextInt(30) + 10;
            for (int nameIdx = 0; nameIdx < nameLength; nameIdx++) {
                name.append((char)('a' + random.nextInt(26)));
            }

            list.add(new Human(name.toString(), random.nextInt(80), Util.Gender.values()[random.nextInt(2)]));
        }

        return list;
    }


    public static void main(String[] args) {
        List<Human> list = generateHumanList(100000);
        List<Human> secondList = List.copyOf(list);
//        System.out.println("Первый");
//        list.forEach(System.out::println);
//        System.out.println("\n\nВторой");
//        secondList.forEach(System.out::println);

        Week3.Task1.Util.BubbleSort bubbleSort = new Util.BubbleSort();
        Week3.Task1.Util.AnotherSort anotherSort = new Util.AnotherSort();


        System.out.println("\n\nПервый после сортировки:");
        long startTime = System.currentTimeMillis();
        anotherSort.sort(list);
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
}
