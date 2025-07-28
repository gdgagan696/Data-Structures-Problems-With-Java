package dsquestions.leetcodeds1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                int sum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                temp.add(sum);
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
