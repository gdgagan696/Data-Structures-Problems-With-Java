package dsquestions.dp;

public class PartitionEqualSubset {
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        if((sum&1)==1)return false;
        Boolean [][]dp=new Boolean[nums.length+1][sum/2+1];
        for (int i=0;i<=nums.length;i++){
            dp[i][0]=true;
        }
        for (int i=0;i<=sum/2;i++){
            dp[0][i]=false;

        }
        return subSetSum(nums,sum/2,nums.length-1,dp);

    }


    private static boolean subSetSum(int[] nums, int sum, int i,Boolean[][]dp) {
        if(sum==0)return true;
        if(i<=0 || sum<0)return false;
        if(dp[i][sum]!=null)return dp[i][sum];
        boolean temp;
        if(sum>=nums[i]){
            temp=subSetSum(nums,sum-nums[i],i-1,dp)|| subSetSum(nums,sum,i-1,dp);
        }
        else{
            temp=subSetSum(nums,sum,i-1,dp);
        }
        dp[i][sum]=temp;
        return temp;
    }

    public static void main(String[]args){
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }
}
