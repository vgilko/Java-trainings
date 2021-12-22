package Week2;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

// Написать метод, который добавляет 1000000 элементов в ArrayList и LinkedList.
// Написать еще один метод, который выбирает из заполненного списка элемент наугад 100000 раз.
// Замерьте время, которое потрачено на это.
public class Task4 {
    final static int ELEMENTS_AMOUNT = 1000000;
    final static int GET_OPERATIONS_AMOUNT = 100000;

    public static void generateList (List<Integer> list) {
        Random rand = new Random();

        for (int i = 0; i < ELEMENTS_AMOUNT; i++) {
            list.add(rand.nextInt());
        }
    }

    public static void getRandomElement (List<Integer> list) {
        Random rand = new Random();
        for (int i = 0; i < GET_OPERATIONS_AMOUNT; i++) {
            int index = rand.nextInt(list.size());
            list.get(index);
        }
    }

    public static void checkList (List<Integer> list) {
        System.out.printf("Генерация %s: ", list.getClass().getName());

        long startTime = System.currentTimeMillis();
        generateList(list);
        System.out.println((System.currentTimeMillis() - startTime));

        System.out.printf("Извлечение элемента из %s: ", list.getClass().getName());
        startTime = System.currentTimeMillis();
        getRandomElement(list);
        System.out.println((System.currentTimeMillis() - startTime));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        checkList(arrayList);
        System.out.println("------------");
        checkList(linkedList);
        System.out.println("Завершил работу.");

        // Результат:
        //Генерация java.util.ArrayList: 30
        //Извлечение элемента из java.util.ArrayList: 12
        //------------
        //Генерация java.util.LinkedList: 158
        //Извлечение элемента из java.util.LinkedList: 84967
        //Завершил работу.
    }
}
