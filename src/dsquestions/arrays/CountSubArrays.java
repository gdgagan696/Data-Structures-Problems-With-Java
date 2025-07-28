package dsquestions.arrays;

import java.util.Arrays;

public class CountSubArrays {
    public static long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int i = 0,j=0;

        while (j < nums.length) {
            k -= nums[j] == max ? 1 : 0;
            j++;
            while (k == 0) {
                k += nums[i] == max ? 1 : 0;
                i++;
            }
            ans += i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,2,3,3},2));
    }
}
