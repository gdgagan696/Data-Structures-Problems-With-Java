package dsquestions.arrays;

public class CapacityToShipPackagesWithinDDays {
    public static int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int total = 0;
        for (int x : weights) {
            max = Math.max(max, x);
            total += x;
        }
        if (days == weights.length) {
            return max;
        }
        int low = max;
        int high = total;
        int minDays = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossibleWeight(weights, mid, days)) {
                minDays = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minDays;

    }

    private static boolean isPossibleWeight(int[] weights, int mid, int days) {
        int reqDays = 1;
        int sum = 0;
        for (int x : weights) {
            sum += x;
            if (sum > mid) {
                sum = x;
                reqDays++;
            }
        }
        return reqDays <= days;
    }

    public static void main(String[] args) {
        int weights[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(shipWithinDays(weights, 5));
    }
}
