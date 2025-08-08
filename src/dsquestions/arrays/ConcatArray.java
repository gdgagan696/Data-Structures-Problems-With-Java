package dsquestions.arrays;

import java.util.Arrays;

public class ConcatArray {

    public static int[] getConcatenation(int[] nums) {

        int[] res = new int[2 * nums.length];
        int i = 0;
        int k = 0;
        int n = nums.length;
        while (i < nums.length) {
            res[k] = nums[i];
            res[k + n] = nums[i];
            i++;
            k++;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 1})));
    }

}
