package dsquestions.arrays;

import java.util.Arrays;

public class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);

        int low = 1;
        int high = piles[piles.length - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEatBananas(piles, h, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean canEatBananas(int[] piles, int h, int mid) {

        int hours = 0;
        for (int bananas : piles) {
            hours += bananas / mid;
            hours += (bananas % mid == 0) ? 0 : 1;
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }
}
