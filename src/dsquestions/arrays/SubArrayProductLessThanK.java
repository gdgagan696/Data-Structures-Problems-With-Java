package dsquestions.arrays;

public class SubArrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int i = 0;
        int j = 0;
        int res = 0;
        int prod = 1;
        while (j < nums.length) {
            prod *= nums[j];
            while (prod >= k && i < nums.length) {
                prod = prod / nums[i++];
            }
            res += (j - i + 1);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{1, 1, 1, 1}, 1));
    }
}
