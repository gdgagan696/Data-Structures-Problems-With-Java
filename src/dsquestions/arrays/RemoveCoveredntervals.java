package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RemoveCoveredntervals {
    public static int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];
        result.add(prev);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev[0] && intervals[i][1] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                result.add(prev);
                prev = intervals[i];
            }
        }
        return result.size();
    }

    public static int removeCoveredIntervals_WithOutList(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        int[] prev = intervals[0];
        int result = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev[0] && intervals[i][1] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                result++;
                prev = intervals[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2}, {1, 4}, {3, 4}
        };
        System.out.println(removeCoveredIntervals(intervals));
        System.out.println(removeCoveredIntervals_WithOutList(intervals));
    }
}
