package dsquestions.Dsstudy1;

import java.util.Arrays;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {

        int res[]=new int[nums.length];
        int j=nums.length-1;
        int k=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[j--]=0;
            }
            else {
                nums[k++]=nums[i];
            }
        }
        System.arraycopy(res,0,nums,0,nums.length);
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[]args){
        moveZeroes(new int[]{0,1,0,3,12});
    }
}
