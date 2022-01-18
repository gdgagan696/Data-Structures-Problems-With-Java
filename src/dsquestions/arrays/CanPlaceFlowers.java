package dsquestions.arrays;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers_DP(int[] flowerbed, int n) {

        Boolean dp[] = new Boolean[flowerbed.length];
        return canPlaceFlowers_DP(flowerbed, n, 0, dp);
    }

    private static boolean canPlaceFlowers_DP(int[] flowerbed, int n, int i, Boolean[] dp) {

        if (n == 0) return true;
        if (n < 0 || i >= flowerbed.length) return false;
        if (dp[i] != null) return dp[i];
        Boolean ans = false;
        if (flowerbed[i] == 1) {
            ans = canPlaceFlowers_DP(flowerbed, n, i + 2, dp);
        } else {
            if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                ans = canPlaceFlowers_DP(flowerbed, n - 1, i + 2, dp);
            }
            ans = ans || canPlaceFlowers_DP(flowerbed, n, i + 1, dp);
        }
        dp[i] = ans;
        return ans;


    }

    public static boolean canPlaceFlowers_Greedy(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length) {
            if (n == 0) return true;
            if (flowerbed[i] == 1) {
                i += 2;
            } else {
                if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                    n--;
                    i += 2;
                } else {
                    i++;
                }
            }
        }
        return n == 0;


    }


    public static void main(String[] args) {
        System.out.println(canPlaceFlowers_DP(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers_Greedy(new int[]{1, 0, 0, 0, 1}, 2));
    }
}
