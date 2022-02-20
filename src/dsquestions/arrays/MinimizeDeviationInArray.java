package dsquestions.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeDeviationInArray {

    public static int minimumDeviation(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int diff;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                nums[i] = nums[i] * 2;
            }
            pq.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        diff = max - min;
        while ((pq.peek() & 1) == 0) {
            int num = pq.poll();
            diff = Math.min(diff, num - min);
            min = Math.min(min, num / 2);
            pq.add(num / 2);
        }
        return Math.min(diff, pq.peek() - min);
    }

    public static void main(String[] args) {
        System.out.println(minimumDeviation(new int[]{1, 2, 3, 4}));
    }
}
