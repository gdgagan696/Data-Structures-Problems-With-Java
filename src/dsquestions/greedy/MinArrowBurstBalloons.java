package dsquestions.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowBurstBalloons {

    public static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int i = 0;
        int minArrow = 0;
        while (i < points.length) {
            int start = points[i][1];
            minArrow++;
            while (i < points.length && points[i][0] <= start && start <= points[i][1]) {
                i++;
            }
        }
        return minArrow;

    }

    public static void main(String[] args) {
        int[][] points = {
                {10, 16}, {2, 8}, {1, 6}, {7, 12}
        };
        System.out.println(findMinArrowShots(points));
    }
}
