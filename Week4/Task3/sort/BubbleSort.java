package Week4.Task3.sort;
import Week4.Task3.interfaces.Sortable;

import java.util.List;


public class BubbleSort implements Sortable {
    private static Sortable sortable;

    private BubbleSort () {

    }

    public static Sortable getInstance () {
        if (sortable == null) {
            sortable = new BubbleSort();
        }

        return sortable;
    }

    @Override
    public <T extends Comparable<T>> void sort(List<T> values) {
        for (int m = 0; m < values.size (); m++) {
            for (int n = 0; n < values.size() - 1; n++) {
                if (values.get(n).compareTo(values.get(n + 1)) > 0) {
                    T temp = values.get(n);
                    values.set(n, values.get(n + 1));
                    values.set(n + 1, temp);
                }
            }
        }

    }
}
