package dsquestions.arrays;

import java.util.Arrays;

public class MissingNumberRevision {

    public int missingNumber(int[] nums) {

        int n = nums.length;
        int actualSum = n * (n + 1) / 2;
        int sum = Arrays.stream(nums).sum();
        return actualSum - sum;

    }

}
