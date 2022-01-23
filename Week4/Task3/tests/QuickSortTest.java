package Week4.Task3.tests;

import Week4.Task3.sort.QuickSort;

public class QuickSortTest {
    public static void main(String[] args) {
        SortTest sort = new SortTest(QuickSort.getInstance());
        sort.testSort();
    }
}
