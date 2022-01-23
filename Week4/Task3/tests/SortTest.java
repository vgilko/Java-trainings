package Week4.Task3.tests;

import Week4.Task3.interfaces.Sortable;
import Week4.Task3.sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTest {
    private final Sortable sort;

    SortTest(Sortable sort) {
        this.sort = sort;
    }

    public void testSort () {
        System.out.println("Начал тестирование.");

        test(Arrays.asList(1, 0, 123, 2, 1));
        test(Arrays.asList(0, 0, 0, 0));
        test(new ArrayList<Integer>());
        test(Arrays.asList(1));

        System.out.println("Успешно завершил тестирование.");
    }

    private static <T extends Comparable<T>> void test (List<T> values) {
        QuickSort.getInstance().sort(values);

        for (int i = 1; i < values.size() - 1; i++) {
            if (values.get(i - 1).compareTo(values.get(i)) > 1) {
                throw new RuntimeException("Последовательность не монотонна.");
            }
        }
    }
}
