package Week3.Task1.Sort;

import Week3.Task1.Interfaces.Sortable;

import java.util.List;

public class QuickSort implements Sortable {
    @Override
    public <T extends Comparable> void sort(List<T> values) {
        if (values != null)
            quickSort(values, 0, values.size() - 1);
    }

    private <T extends Comparable> void quickSort (List<T> values, int first, int second) {
        if (first < second) {
            int middle = partition(values, first, second);

            quickSort(values, first, middle);
            quickSort(values, middle + 1, second);
        }
    }

    private <T extends Comparable> int partition (List<T> values, int low, int high) {
        T middle = values.get((low + high) / 2);

        int first = low,
            second = high;

        while (true) {
            while (values.get(first).compareTo(middle) < 0)
                first++;
            while (values.get(second).compareTo(middle) > 0)
                second--;

            if (first >= second)
                return second;

            first++;
            second--;

            T temp = values.get(first);
            values.set(first, values.get(second));
            values.set(second, temp);
        }
    }
}
