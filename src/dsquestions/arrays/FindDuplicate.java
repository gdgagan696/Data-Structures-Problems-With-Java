package dsquestions.arrays;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        for(int x:nums){
            int index=Math.abs(x);
            if(nums[index]<0){
                return Math.abs(x);
            }
            else {
                nums[index]=-1*nums[index];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,2,3,2}));
    }
}
