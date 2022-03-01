package dsquestions.dp;

import java.util.Arrays;

public class CountingBits {
    public static int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        int res[] = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + res[i % 2];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(10)));
    }
}
