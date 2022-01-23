package Week4.Task3.human_service;

import Week4.Task3.Human;

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
