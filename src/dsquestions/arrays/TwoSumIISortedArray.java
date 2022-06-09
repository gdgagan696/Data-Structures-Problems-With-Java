package dsquestions.arrays;

import java.util.Arrays;

public class TwoSumIISortedArray {

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

}
