package dsquestions.maths;

import java.util.Arrays;

public class ArraySign {
    public static int arraySign(int[] nums) {
        int count=0;
        for(int x:nums){
            if(x==0)return 0;
            if(x<0)count++;
        }
        return (count&1)==0?1:-1;
    }

    public static void main(String[]args){
//        System.out.println(arraySign(new int[]{-1,-2,-3,-4,3,2,1}));
        System.out.println(arraySign(new int[]{56,32,76,92,78,91,-100,-82,-40,-63,-48,-55,-59,-81,-35,-59,-29}));
    }

}
