package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] > b[0]) return 1;
            else if (a[0] == b[0]) return 0;
            else return -1;
        });
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[j][1] >= intervals[i][0]) {
                intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
                intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
            } else {
                j++;
                intervals[j] = intervals[i];
            }
        }
        int[][] result = new int[j + 1][2];
        for (int i = 0; i <= j; i++) {
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }
        return result;
    }

    public static int[][] merge_2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (prev[1] >= intervals[i][0]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                result.add(prev);
                prev = intervals[i];
            }
        }
        result.add(prev);

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[][]{{1, 4}, {5, 7}, {2, 6}})));
        System.out.println(Arrays.toString(merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.toString(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.toString(merge_2(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));

    }
}
