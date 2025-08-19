package dsquestions.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortStudentsByKthScore {

    public static int[][] sortTheStudents(int[][] score, int k) {

        int[][] res = new int[score.length][score[0].length];
        Map<Integer, Integer> hm = new HashMap<>();
        int[] kthScore = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            kthScore[i] = score[i][k];
            hm.put(score[i][k], i);
        }
        kthScore = Arrays.stream(kthScore).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(i -> i).
                toArray();
        for (int i = 0; i < kthScore.length; i++) {
            int studentNum = hm.get(kthScore[i]);
            res[i] = score[studentNum];
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] score = {
                {10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}
        };
        Arrays.stream(sortTheStudents(score, 2)).forEach(arr -> System.out.println(Arrays.toString(arr)));

    }

}
