package dsquestions.trees;

import java.util.Arrays;
import java.util.Collections;

public class MaxSumNodeValue {
    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        long[] delta = new long[nums.length];
        long res=0;
        for (int i = 0; i < nums.length; i++) {
            delta[i] = (nums[i] ^ k) - nums[i];
            res+=nums[i];
        }
        delta = Arrays.stream(delta).boxed()
                .sorted(Collections.reverseOrder())
                .mapToLong(Long::longValue)
                .toArray();
        for (int i = 0; i < delta.length; i += 2) {
            if (i == delta.length - 1) {
                break;
            }
            long sum = delta[i] + delta[i + 1];
            if (sum <= 0) {
                break;
            }
            res += sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int []nums={1,2,1};
        int [][]edges={{0,1},{0,2}};
        System.out.println(maximumValueSum(nums,3,edges));
    }

}
