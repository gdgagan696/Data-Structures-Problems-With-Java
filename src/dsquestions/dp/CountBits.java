package dsquestions.dp;

import java.util.Arrays;

public class CountBits {
    public static int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        if (n == 0) return res;
        res[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i / 2] + 1;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
