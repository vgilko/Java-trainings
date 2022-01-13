package Week3.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

interface Sortable {
    void sort (List<Human> values);
}

public class Util {
    public static AnotherSort AnotherSort;
    public static BubbleSort BubbleSort;

    public static class BubbleSort implements Sortable {

        @Override
        public void sort(List<Human> values) {
            for (int m = 0; m < values.size (); m++) {
                for (int n = 0; n < values.size() - 1; n++) {
                    if (values.get(n).compareTo(values.get(n + 1)) > 0) {
                        Human temp = values.get(n);
                        values.set(n, values.get(n + 1));
                        values.set(n + 1, temp);
                    }
                }
            }

        }
    }

    public static class AnotherSort implements Sortable {

        @Override
        public void sort(List<Human> values) {
            values.sort(Human::compareTo);
        }
    }

    public static class Finder {
        public static Human find (List<Human> list, Human toFind) {
            Optional<Human> first = list.
                                        stream().
                                        filter((Human x) -> x.compareTo(toFind) == 0).
                                        findFirst();

            if (first.isEmpty()) {
                throw new NoSuchElementException("Не найден элемент: " + toFind.toString());
            }

            return first.get();
        }
    }


    public static boolean isAllDigit (String input) {
        if (input == null) {
            return false;
        }

        return input.trim()
                .chars()
                .allMatch(Character::isDigit);
    }

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

    public static enum Gender {
        MAN, WOMAN;
    }
}
