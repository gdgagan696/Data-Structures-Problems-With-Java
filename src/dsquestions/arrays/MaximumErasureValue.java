package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaximumErasureValue {
    public static int maximumUniqueSubarray(int[] nums) {

        int i=0;
        int j=0;
        int n=nums.length;
        Map<Integer,Integer> hm=new HashMap<>();
        int tempSum=0;
        int maxSum=0;
        while (j<n){
            tempSum+=nums[j];
            hm.put(nums[j],hm.getOrDefault(nums[j],0)+1 );
            if(hm.get(nums[j])>1){
                while (hm.size()<j-i+1){
                    hm.put(nums[i],hm.get(nums[i])-1);
                    tempSum-=nums[i];
                    if(hm.get(nums[i])==0){
                        hm.remove(nums[i]);
                    }
                    i++;
                }
            }
            else {
                maxSum=Math.max(tempSum,maxSum);
            }
            j++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4,2,4,5,6}));
    }
}
