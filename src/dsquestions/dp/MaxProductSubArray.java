package dsquestions.dp;

public class MaxProductSubArray {

    public static int maxProduct(int[] nums) {

        int min=nums[0];
        int max=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            res=Math.max(res,max);
        }
        return res;
    }

    public static void main(String[]args){
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
}
