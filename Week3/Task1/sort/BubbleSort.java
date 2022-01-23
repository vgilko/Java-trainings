package Week3.Task1.sort;
import java.util.List;

import Week3.Task1.interfaces.Sortable;


public class BubbleSort implements Sortable {

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
