package dsquestions.dp;

import java.util.HashMap;
import java.util.Map;

public class EqualPartitionSum {
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        Map<String,Boolean> hm=new HashMap<>();
        if(sum%2!=0)return false;
        else return canPartition(nums,sum/2,nums.length,hm);
    }

    public static boolean canPartition(int[]nums,int sum,int n,Map<String,Boolean>hm){
        if(sum==0)return true;
        if(n==0)return false;

        if(hm.containsKey(n+"-"+sum))return hm.get(n+"-"+sum);
        if(nums[n-1]<=sum){
            boolean b=canPartition(nums,sum-nums[n-1],n-1,hm)||canPartition(nums,sum,n-1,hm);
            hm.put(n+"-"+sum,b);
        }
        else {
            boolean b = canPartition(nums, sum, n - 1, hm);
            hm.put(n+"-"+sum,b);
        }
        return hm.get(n+"-"+sum);

    }

    public static void main(String[]args){
        System.out.println(canPartition(new int[]{1,5,11,5}));

    }
}
