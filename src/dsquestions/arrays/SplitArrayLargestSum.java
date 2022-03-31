package dsquestions.arrays;

public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int m) {

        int max = 0;
        int total = 0;
        for (int x : nums) {
            max = Math.max(max, x);
            total += x;
        }
        if (m == nums.length) {
            return max;
        }
        int low = max;
        int high = total;
        int minLargestSum = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossibleSplit(nums, mid, m)) {
                minLargestSum = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minLargestSum;

    }

    private static boolean isPossibleSplit(int[] nums, int mid, int m) {
        int split = 0;
        int sum = 0;
        for (int x : nums) {
            sum += x;
            if (sum > mid) {
                sum = x;
                split++;
            }
        }
        return split <= m;
    }

    public static void main(String[] args) {
        int nums[] = {7, 2, 5, 10, 8};
        System.out.println(splitArray(nums, 2));
    }
}
