package Week3.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Week3.Task1.Util.Gender.MAN;

public class Tests {

    static List<String> generatePhones (int amount) {
        final boolean WITH_INVALID_PHONES = false;
        final int GENERATION_BOUND = WITH_INVALID_PHONES ? 12 : 10;

        Random random = new Random();
        List<String> phones = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            StringBuilder phone = new StringBuilder();

            for (int phoneIdx = 0; phoneIdx < 12; phoneIdx++) {
                phone.append((char)('0' + random.nextInt(GENERATION_BOUND)));
            }

            phones.add(phone.toString());
        }

        return phones;
    }

    static Human generateHuman () {
        Random random = new Random();

        StringBuilder name = new StringBuilder();

        int nameLength = random.nextInt(30) + 10;
        for (int nameIdx = 0; nameIdx < nameLength; nameIdx++) {
            name.append((char)('a' + random.nextInt(26)));
        }
        return new Human(name.toString(), random.nextInt(80), Util.Gender.values()[random.nextInt(2)]);
    }


    static List<Human> generateHumanList (int amount) {
        List<Human> list = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            list.add(generateHuman());
        }

        return list;
    }

    static List<Human> generateHumanListWithPhones (int amount) {
        Random random = new Random();
        List<Human> list = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            Human human = generateHuman();
            human.addPhones(generatePhones(random.nextInt(11)));
            list.add(human);

        }

        return list;
    }

    static void testFirstTask () {
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


    static void testFind () {
        List<Human> list = generateHumanList(50);
        list.add(new Human("valera", 12, MAN));

        list.forEach(System.out::println);
        System.out.println("==============");

        System.out.println(Util.Finder.find(list, new Human("valera", 12, MAN)));

    }

    static void testGetPhoneBook () {
        List <Human> list = generateHumanListWithPhones(10);
        list.forEach(x -> {
            System.out.println(x.getPhoneBook());
        });

        System.out.println("------------");
        List<String> phones = Util.getHumansPhoneBooks(list);
        if (phones != null) {
            System.out.println(phones);
        }
    }


    public static void main(String[] args) {
        testGetPhoneBook();
    }
}
