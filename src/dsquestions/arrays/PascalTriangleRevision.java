package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleRevision {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            List<Integer> prev = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                current.add(prev.get(j) + prev.get(j - 1));
            }
            current.add(1);
            result.add(current);
        }
        return result;

    }

    public static void main(String[] args) {

        System.out.println(generate(5));
    }

}
