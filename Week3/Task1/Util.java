package Week3.Task1;

import java.util.List;
import java.util.stream.Collectors;

interface Sortable {
    void sort (List<Human> values);
}

public class Util {
    public static AnotherSort AnotherSort;
    public static BubbleSort BubbleSort;

    public static class BubbleSort implements Sortable {

        @Override
        public void sort(List<Human> values) {
            for (int m = 0; m < values.size (); m++) {
                for (int n = 0; n < values.size() - 1; n++) {
                    if (values.get(n).compareTo(values.get(n + 1)) > 0) {
                        Human temp = values.get(n);
                        values.set(n, values.get(n + 1));
                        values.set(n + 1, temp);
                    }
                }
            }

        }
    }

    public static class AnotherSort implements Sortable {

        @Override
        public void sort(List<Human> values) {
            values.sort(Human::compareTo);
        }
    }

    public static enum Gender {
        MAN, WOMAN;
    }
}
