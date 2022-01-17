package Week3.Task1.tests;

import Week3.Task1.Human;
import Week3.Task1.human_service.Finder;
import Week3.Task1.human_service.HumanUtils;
import Week3.Task1.enums.Gender;

import java.util.List;

import static Week3.Task1.tests.Generators.generateHumanList;
import static Week3.Task1.tests.Generators.generateHumanListWithPhones;

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
