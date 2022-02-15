package dsquestions.arrays;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int res=nums[0];
        for(int i=1;i<nums.length;i++) {
            res ^= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,2,2,1,3}));
    }
}
