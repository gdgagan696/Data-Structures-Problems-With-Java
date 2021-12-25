package dsquestions.arrays;

public class MaxConsectiveOnesIII {
    public static int longestOnes(int[] nums, int k) {

        int i = 0, j = 0, n = nums.length;
        int zero = k;
        while (j < n) {
            if (nums[j] == 0) {
                zero--;
            }
            if (zero < 0) {
                if (nums[i] == 0) {
                    zero++;
                }
                i++;
            }
            j++;
        }
        return j - i;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        System.out.println(longestOnes(new int[]{0, 0, 0, 1}, 4));

    }
}
