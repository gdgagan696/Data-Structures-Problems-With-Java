package dsquestions.arrays;

import java.util.Arrays;

public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        if (nums.length == 0) {
            return ans;
        }
        ans[0] = searchFirstOccurence(nums, target);
        ans[1] = searchLastOccurence(nums, target);
        return ans;


    }

    private static int searchFirstOccurence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid - 1] < target) && nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int searchLastOccurence(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == nums.length - 1 || nums[mid + 1] > target) && nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//		System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 3)));
//		System.out.println(Arrays.toString(searchRange(new int[]{1},1)));
    }

}
