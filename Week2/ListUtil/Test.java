package Week2.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void testFindFirstOverValue () {
        List<List<Integer>> testData = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(12, 1234,312312,2),
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(12),
                Arrays.asList(0,0,0),
                Arrays.asList(1, 1, 1, 1),
                Arrays.asList()
                );

        for (List<Integer> values : testData) {
            System.out.println(Util.getValue(values, 2));
        }
    }

    public static void main(String[] args) {
        testFindFirstOverValue();
    }
}
