package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReArrangeArray {
    public static int[] rearrangeArray(int[] nums) {
        List<Integer>pos=new ArrayList<>();
        List<Integer> neg=new ArrayList<>();
        for(int num:nums){
            if(num>=0){
                pos.add(num);
            }
            else {
                neg.add(num);
            }
        }
        int []res=new int[nums.length];
        int j=0;
        for (int i=0;i<res.length;i+=2){
            res[i]=pos.get(j);
            res[i+1]=neg.get(j);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3,1,-2,-5,2,-4})));
    }
}
