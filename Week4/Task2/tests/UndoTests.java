package Week4.Task2.tests;

import Week4.Task2.MyList;

public class UndoTests {
    static void undoTest () {
        MyList<Integer> list = new MyList<>();

        list.pushBack(123);
        list.pushBack(12);
        list.pushBack(1);
        list.print();
        System.out.println("-----------");
        list.popBack();
        list.popBack();
        list.print();
        System.out.println("-----------");
        list.undo();
        list.undo();
        list.print();
    }

    public static void main(String[] args) {
        undoTest();
    }
}
