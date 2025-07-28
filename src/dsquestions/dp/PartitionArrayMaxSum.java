package dsquestions.dp;

public class PartitionArrayMaxSum {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[]dp=new Integer[arr.length+1];
        return maxSumAfterPartitioningUtil(arr, k, 0,dp);
    }

    private static int maxSumAfterPartitioningUtil(int[] arr, int k, int i,Integer[]dp) {
        if (i >= arr.length) {
            return 0;
        }
        if(dp[i]!=null){
            return dp[i];
        }
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int len = 0;
        for (int j = i; j < Math.min(arr.length, i + k); j++) {
            len++;
            max = Math.max(max, arr[j]);
            int temp = len * max + maxSumAfterPartitioningUtil(arr, k, j + 1,dp);
            sum = Math.max(sum, temp);
        }
        return dp[i]=sum;
    }

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    }
}
