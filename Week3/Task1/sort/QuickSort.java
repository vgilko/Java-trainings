package Week3.Task1.sort;

import Week3.Task1.interfaces.Sortable;

import java.util.List;

public class QuickSort implements Sortable {
    @Override
    public <T extends Comparable<T>> void sort(List<T> values) {
        if (values != null) {
            quickSort(values, 0, values.size() - 1);
        }
    }

    private <T extends Comparable<T>> void quickSort (List<T> values, int first, int second) {
        if (first < second) {
            int middle = partition(values, first, second);

            quickSort(values, first, middle);
            quickSort(values, middle + 1, second);
        }
    }

    private <T extends Comparable<T>> int partition (List<T> values, int low, int high) {
        T middle = values.get((low + high) / 2);

        int first = low,
            second = high;

        while (true) {
            while (first < values.size() && values.get(first).compareTo(middle) < 0)
                first++;
            while (second >= 0 && values.get(second).compareTo(middle) > 0)
                second--;

            if (first >= second) {
                return second;
            }

            T temp = values.get(first);
            values.set(first, values.get(second));
            values.set(second, temp);
        }
    }
}
