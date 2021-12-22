package dsquestions.arrays;

public class LongestContinuousIncreasingSubSequence {

    private static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxLen = 1;
        int maxTillHere = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                maxTillHere++;
            } else {
                maxTillHere = 1;
            }
            if (maxTillHere > maxLen) {
                maxLen = maxTillHere;
            }

        }
        return maxLen;

    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));

    }
}
