package dsquestions.arrays;

public class EqualDivisiblePairs {

    public static int countPairs(int[] nums, int k) {

        int pair = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (i*j % k) == 0) {
                    pair++;
                }
            }
        }

        return pair;
    }

    public static void main(String[] args) {

        System.out.println(countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2));

    }

}
