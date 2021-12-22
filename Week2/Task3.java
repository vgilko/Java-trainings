package Week2;

// Написать метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.

import java.util.Collections;
import java.util.HashSet;

public class Task3 {
    static class DeleteDuplicates {
        DeleteDuplicates (Collections collection) {
            if (collection == null) {
                throw new IllegalArgumentException ("Некорректный аргумент."); // не знаю, что делать в этой ситуации))
            }

            Class<? extends Collections> objectClass = collection.getClass();

//            HashSet<? extends Collections> set = new HashSet<> (collection);
        }
    }
}
