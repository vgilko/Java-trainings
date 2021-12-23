package Week2;

// Написать метод, который на вход получает коллекцию объектов, а возвращает коллекцию уже без дубликатов.

import javax.swing.text.DefaultEditorKit;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    static class DeleteDuplicates {

        public static <UserType> Collection<UserType> deleteDuplicates (Collection<UserType> collection) {
            if (collection == null) {
                throw new IllegalArgumentException ("Некорректный аргумент."); // не знаю, что делать в этой ситуации))
            }

            Class<?> objectClass = collection.getClass();
            System.out.println(objectClass.toString());

            if (collection instanceof List ||
                collection instanceof Queue) {
                Set<UserType> set = Set.copyOf(collection);

                collection.clear();
                collection.addAll(set);
            }

            return collection;
        }
    }

    public static void testDeleteDuplicates () {
        Map<Collection<Integer>, Collection<Integer>> testToResult = Map.ofEntries(
                Map.entry(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 3,3,3)), new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))),
                Map.entry(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))),
                Map.entry(new ArrayList<>(), new ArrayList<>()),
                Map.entry(new ArrayDeque<>(), new ArrayDeque<>()),
                Map.entry(new ArrayDeque<>(Arrays.asList(1,1,1,11)), new ArrayDeque<>(Arrays.asList(1, 11))),
                Map.entry(new HashSet<> (Arrays.asList(1,1,1,1)), new HashSet<> (List.of(1))),
                Map.entry(new HashSet<> (), new HashSet<> ())
        );

        for (Map.Entry<Collection<Integer>, Collection<Integer>> pair : testToResult.entrySet()) {
            Collection<Integer> result = DeleteDuplicates.deleteDuplicates(pair.getKey());

            Integer[] arrayResult = new Integer[result.size()];
            result.toArray(arrayResult);

            ArrayList<Integer> sortedResult = (ArrayList<Integer>) result.stream().sorted().collect(Collectors.toList());
            ArrayList<Integer> sortedExpectedResult = (ArrayList<Integer>) pair.getValue().stream().sorted().collect(Collectors.toList());

            if (sortedExpectedResult.size() != sortedResult.size()) {
                throw new AssertionError(pair.getKey() + ": expected: " + sortedExpectedResult + ", result: " + sortedResult);
            }

            for (int i = 0; i < sortedResult.size(); i++) {
                if (!Objects.equals(sortedResult.get(i), sortedExpectedResult.get(i))) {
                    throw new AssertionError(pair.getKey() + ": expected: " + sortedExpectedResult + ", result: " + sortedResult);
                }
            }

            if (result.getClass() != pair.getValue().getClass()) {
                throw new AssertionError(pair.getKey() + ": expected: " + pair.getValue().getClass() + ", result: " + result.getClass());
            }
        }
    }

    public static void main(String[] args) {
        testDeleteDuplicates();
    }
}
