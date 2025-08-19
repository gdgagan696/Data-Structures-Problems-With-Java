package dsquestions.arrays;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DistinctIntAfterReverse {

    public static int countDistinctIntegers(int[] nums) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i < nums.length; i++) {
            int reverse = Integer.parseInt(new StringBuilder(String.valueOf(nums[i])).reverse().toString());
            set.add(reverse);
        }
        return set.size();


    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 10, 12, 31};
        System.out.println(countDistinctIntegers(nums));
    }

}
