package dsquestions.maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArithmeticSubarrays {

    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
            int min = Arrays.stream(arr).min().getAsInt();
            int max = Arrays.stream(arr).max().getAsInt();
            int n = arr.length;
            if ((max - min) % (n - 1) != 0) {
                res.add(false);
                continue;
            }
            int d = (max - min) / (n - 1);
            int start = min;
            int k = 1;
            boolean ap = true;
            while (k < n) {
                int next = start + d;
                start = next;
                if (!set.contains(next)) {
                    ap = false;
                    break;
                }
                k++;
            }
            res.add(ap);

        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0, 0, 2};
        int[] r = {2, 3, 5};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }

}
