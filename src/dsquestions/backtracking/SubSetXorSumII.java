package dsquestions.backtracking;

public class SubSetXorSumII {
    public static int subsetXORSum(int[] nums) {

        return subsetXORSumUtil(nums, 0,0);

    }

    private static int subsetXORSumUtil(int[] nums, int i,int sum) {
        if (i >= nums.length) {
            return sum;
        }
        return subsetXORSumUtil(nums,i+1,sum)+subsetXORSumUtil(nums,i+1,sum^nums[i]);
    }

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
    }
}
