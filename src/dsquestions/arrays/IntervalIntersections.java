package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersections {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<Integer[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < firstList.length && j < secondList.length) {
            int s = Math.max(firstList[i][0], secondList[j][0]);
            int e = Math.min(firstList[i][1], secondList[j][1]);
            if (s <= e) {
                res.add(new Integer[]{s, e});
            }
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.stream()
                .map(a -> Arrays.stream(a).mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

    }

    public static void main(String[] args) {

        int[][] firstList = {{7, 13}, {16, 20}};
        int[][] secondList = {{14, 16}};
        int[][] res = intervalIntersection(secondList, firstList);
        Arrays.stream(res).forEach(a -> System.out.println(Arrays.toString(a)));
    }

}
