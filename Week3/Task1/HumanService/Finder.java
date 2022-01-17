package Week3.Task1.HumanService;

import Week3.Task1.Human;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Finder {
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