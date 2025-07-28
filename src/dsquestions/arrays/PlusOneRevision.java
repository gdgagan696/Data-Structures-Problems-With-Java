package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PlusOneRevision {

    public static int[] plusOne(int[] digits) {

        int carry = 1;
        int i = digits.length - 1;
        List<Integer> res = new ArrayList<>();
        while (i >= 0) {
            int num = digits[i--] + carry;
            carry = num / 10;
            res.add(num % 10);
        }
        if(carry>0){
            res.add(carry);
        }
        Collections.reverse(res);
        return res.stream().mapToInt(a -> a).toArray();
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(plusOne(new int[]{9})));

    }

}
