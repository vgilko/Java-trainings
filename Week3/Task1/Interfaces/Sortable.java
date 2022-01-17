package Week3.Task1.Interfaces;

import java.util.List;

public interface Sortable {
    public <T extends Comparable> void sort(List<T> values);
}
