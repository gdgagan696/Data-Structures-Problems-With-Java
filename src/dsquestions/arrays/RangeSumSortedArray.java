package dsquestions.arrays;

import java.util.Arrays;

public class RangeSumSortedArray {
    public static int rangeSum(int[] nums, int n, int left, int right) {
        int []arr=new int[n*(n+1)/2];
        int modulo=1000000000+7;
        int k=0;
        arr[0]=nums[0];
        for (int i=0;i<n;i++){
            arr[k++]=nums[i];
            for(int j=i+1;j<n;j++) {
                arr[k] = arr[k - 1] + nums[j];
                k++;
            }
        }
        Arrays.sort(arr);
        long sum=0;
        for (int i=left;i<=right;i++){
            sum+=arr[i-1]%modulo;
        }
        return (int) (sum%modulo);

    }

    public static void main(String[] args) {
        int[]nums={1,2,3,4};
        System.out.println(rangeSum(nums,4,1,5));
    }
}
