package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        int carry=1;
        int i=digits.length-1;
        List<Integer> result=new ArrayList<>();
        while (i>=0){
            int num=digits[i]+carry;
            if(num>9){
                carry=1;
                result.add(num%10);
            }
            else{
                carry=0;
                result.add(num);
            }
            i--;
        }
        if(carry>0){
            result.add(carry);
        }
        int resultDigits[]=new int[result.size()];
        i=0;
        for(int j=result.size()-1;j>=0;j--){
            resultDigits[i]=result.get(j);
            i++;
        }
        return resultDigits;

    }

    public static void main(String[]args){
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9})));

    }
}
