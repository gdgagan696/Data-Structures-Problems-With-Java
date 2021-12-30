package dsquestions.arrays;

public class PeakElement {
    private static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || nums[mid - 1] <= nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] <= nums[mid])) {
                return mid;
            } else if (mid > 0 && nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));

    }
}
