package Week3.Task1.human_service;

import Week3.Task1.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HumanUtils {
    public static List<String> getHumansPhoneBooks (List<Human> humans) {
        List<String> list = new ArrayList<>();

        if (humans != null && !humans.isEmpty()) {
            list = humans.stream()
                    .map(Human::getPhoneBook)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
        }

        return list;
    }
}
