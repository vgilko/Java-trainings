package Week3.Task1.tests;

import Week3.Task1.sort.QuickSort;

public class QuickSortTest {
    public static void main(String[] args) {
        SortTest sort = new SortTest(new QuickSort());
        sort.testSort();
    }
}
