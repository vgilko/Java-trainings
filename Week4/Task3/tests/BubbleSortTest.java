package Week4.Task3.tests;

import Week4.Task3.sort.BubbleSort;

public class BubbleSortTest {
    public static void main(String[] args) {
        SortTest sort = new SortTest(BubbleSort.getInstance());
        sort.testSort();
    }
}
