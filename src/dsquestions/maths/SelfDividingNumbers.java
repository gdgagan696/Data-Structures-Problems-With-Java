package dsquestions.maths;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public static List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer>result=new ArrayList<>();
        for(;left<=right; left++){
            if(isSelfDividing(left)){
                result.add(left);
            }
        }
        return result;
    }

    private static boolean isSelfDividing(int left) {
        char[] temp = String.valueOf(left).toCharArray();
        for (char ch : temp) {
            int x = Character.getNumericValue(ch);
            if (x == 0 || left % x != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[]args){
        System.out.println(selfDividingNumbers(1,22));

    }
}
