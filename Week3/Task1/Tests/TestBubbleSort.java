package Week3.Task1.Tests;

import Week3.Task1.Sort.BubbleSort;

public class TestBubbleSort {
    public static void main(String[] args) {
        TestSort sort = new TestSort(new BubbleSort());
        sort.testSort();
    }
}
