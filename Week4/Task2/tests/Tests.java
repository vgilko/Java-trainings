package Week4.Task2.tests;

import Week3.Task4.MyList;

public class Tests {

    public static void main(String[] args) {
        MyList<Integer> ints = new MyList<>();

        ints.push_back(12);
        ints.push_back(1);
        ints.push_back(34);

        for (Integer val : ints) {
            System.out.println(val);
        }
    }
}
