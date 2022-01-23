package Week4.Task3.tests;

import Week4.Task3.Human;
import Week4.Task3.enums.Gender;
import Week4.Task3.human_service.Finder;
import Week4.Task3.human_service.HumanUtils;

import java.util.List;

import static Week4.Task3.tests.Generators.generateHumanList;
import static Week4.Task3.tests.Generators.generateHumanListWithPhones;

public class Tests {
    static void testFind () {
        List<Human> list = generateHumanList(50);
        list.add(new Human("valera", 12, Gender.MAN));

        list.forEach(System.out::println);
        System.out.println("==============");

        System.out.println(Finder.find(list, new Human("valera", 12, Gender.MAN)));

    }

    static void testGetPhoneBook () {
        List <Human> list = generateHumanListWithPhones(10);
        list.forEach(x -> {
            System.out.println(x.getPhoneBook());
        });

        System.out.println("------------");
        List<String> phones = HumanUtils.getHumansPhoneBooks(list);
        if (phones != null) {
            System.out.println(phones);
        }
    }


    public static void main(String[] args) {
        testFind();
        System.out.println("\n\nСледующий тест\n\n");
        testGetPhoneBook();
    }
}
