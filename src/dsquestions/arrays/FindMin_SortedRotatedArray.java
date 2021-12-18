package dsquestions.arrays;

public class FindMin_SortedRotatedArray {
    private static int findMin(int[] nums) {
        if(nums.length==1) {
            return nums[0];
        }
        int low=0;
        int high=nums.length-1;

        while (low<=high){
            int mid=low+(high-low)/2;
            if((mid==0 || nums[mid-1]>nums[mid]) && (mid==nums.length-1||nums[mid+1]>nums[mid])){
                return nums[mid];
            }
            else if (nums[mid]>nums[nums.length-1]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;

            }
        }
        return -1;

    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
        System.out.println(findMin(new int[]{2,3,4,5,1}));

    }

}
