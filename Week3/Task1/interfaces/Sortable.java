package Week3.Task1.interfaces;

import java.util.List;

public interface Sortable {
    <T extends Comparable<T>> void sort(List<T> values);
}
