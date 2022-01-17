package Week3.Task1.Tests;

import Week3.Task1.Sort.QuickSort;

public class TestQuickSort {
    public static void main(String[] args) {
        TestSort sort = new TestSort(new QuickSort());
        sort.testSort();
    }
}
