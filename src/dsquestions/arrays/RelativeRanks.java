package dsquestions.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < score.length; i++) {
            pq.add(new int[]{score[i], i});
        }
        String res[] = new String[score.length];
        String[] ranks = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int i = 0;
        while (!pq.isEmpty()) {
            int temp[] = pq.poll();
            if (i <= ranks.length) {
                res[temp[1]] = ranks[i++];
            } else {
                res[temp[1]] = i + 1 + "";
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5, 4, 3, 2, 1})));

    }
}
