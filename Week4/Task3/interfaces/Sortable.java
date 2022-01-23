package Week4.Task3.interfaces;

import java.util.List;

public interface Sortable {
    <T extends Comparable<T>> void sort(List<T> values);
}
