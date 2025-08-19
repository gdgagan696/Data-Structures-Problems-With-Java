package dsquestions.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrefixCommonArray {

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {

        Map<Integer, Integer> hm = new HashMap<>();
        int res[] = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                hm.put(A[i], hm.getOrDefault(A[i], 0) + 2);
                res[i] = i == 0 ? 1 : res[i - 1] + 1;
            } else {
                hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
                hm.put(B[i], hm.getOrDefault(B[i], 0) + 1);
                res[i] = i == 0 ? 0 : res[i - 1];
                if (hm.get(A[i]) % 2 == 0) {
                    res[i]++;
                }
                if (hm.get(B[i]) % 2 == 0) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{1, 2, 3}, new int[]{1, 3, 2})));

    }

}
