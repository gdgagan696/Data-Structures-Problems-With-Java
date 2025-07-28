package dsquestions.binarysearch;

import java.util.Arrays;

public class MinMagneticForce {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length - 1] - position[0];
        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceBalls(position, mid, m)) {
                res = Math.max(mid, res);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;

    }

    private static boolean canPlaceBalls(int[] position, int mid, int m) {
        int prev = position[0];
        int total = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - prev >= mid) {
                total++;
                prev = position[i];
            }
            if (total == m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
    }

}
