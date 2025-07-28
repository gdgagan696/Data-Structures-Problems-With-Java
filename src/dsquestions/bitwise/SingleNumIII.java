package dsquestions.bitwise;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingleNumIII {
    public static int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int x : nums) {
            xor ^= x;
        }
        int bit = 1;
        while ((bit & xor) == 0) {
            bit = bit << 1;
        }
        int a = 0;
        int b = 0;
        for (int x : nums) {
            if ((bit & x) == 0) {
                a = a ^ x;
            } else {
                b = b ^ x;
            }
        }
        res[0] = a;
        res[1] = b;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}

