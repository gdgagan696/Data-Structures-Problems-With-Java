package dsquestions.arrays;

public class NiceSubArrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int m = 0;
        int count = 0;
        int res = 0;
        while (j < nums.length) {
            if (nums[j] % 2 != 0) {
                count++;
            }
            while (count > k) {
                if (nums[i] % 2 != 0) {
                    count--;
                }
                i++;
                m = i;
            }
            if (count == k) {
                while (nums[m] % 2 == 0) {
                    m++;
                }
                res += m - i + 1;
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    }
}
