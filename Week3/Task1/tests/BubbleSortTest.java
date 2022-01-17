package Week3.Task1.tests;

import Week3.Task1.sort.BubbleSort;

public class BubbleSortTest {
    public static void main(String[] args) {
        SortTest sort = new SortTest(new BubbleSort());
        sort.testSort();
    }
}
