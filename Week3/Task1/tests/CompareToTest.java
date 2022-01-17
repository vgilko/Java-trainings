package Week3.Task1.tests;

import Week3.Task1.Human;
import Week3.Task1.enums.Gender;

public class CompareToTest {
    private static void test (Human first, Human second) {
        int firstCompare = first.compareTo(second);
        int secondCompare = second.compareTo(first);

        if (firstCompare != -secondCompare)
            throw new RuntimeException("firstCompare != -secondCompare");
    }


    private static void testCompareTo () {
        test(new Human("Viktor", 12, Gender.MAN), new Human("Viktor", 12, Gender.WOMAN));
        test(new Human("Viktor", 12, Gender.MAN), new Human("Viktor", 11, Gender.MAN));
        test(new Human("Viktor", 12, Gender.MAN), new Human("Viktor", 12, Gender.MAN));
    }

    public static void main(String[] args) {
        testCompareTo();
    }
}
