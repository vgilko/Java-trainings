package Week3.Task1;

import Week3.Task1.Interfaces.Sortable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class Util {
    public static boolean isAllDigit (String input) {
        if (input == null) {
            return false;
        }

        return input.trim()
                .chars()
                .allMatch(Character::isDigit);
    }
}
