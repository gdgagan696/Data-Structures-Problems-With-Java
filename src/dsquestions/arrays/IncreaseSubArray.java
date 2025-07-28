package dsquestions.arrays;

import java.util.Map;

public class IncreaseSubArray {
    public static int maxAscendingSum(int[] nums) {
        int i=1;
        int curr=nums[0];
        int max=nums[0];
        while (i<nums.length){
            if(nums[i-1]<nums[i]){
                curr+=nums[i];
            }
            else {
                curr=nums[i];
            }
            max= Math.max(max,curr);
            i++;
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(maxAscendingSum(new int[]{100,10,1}));
    }

}
