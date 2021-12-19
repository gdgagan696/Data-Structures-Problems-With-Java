package dsquestions.arrays;

public class LCS {
    public static int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        dp[0]=1;
        int res=1;
        for(int i=1;i<nums.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i] && dp[j]>max){
                    max=dp[j];
                }
            }
            dp[i]=max+1;
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[]args){
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

}
