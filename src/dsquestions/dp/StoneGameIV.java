package dsquestions.dp;

public class StoneGameIV {
    public static boolean winnerSquareGame(int n) {

        boolean dp[] = new boolean[n + 1];
        dp[1] = true;
        for (int i = 2; i <= n; i++) {

            boolean aliceWin = false;
            for (int j = 1; j * j <= i; j++) {

                if (!dp[i - j * j]) {
                    aliceWin = true;
                    break;
                }
            }
            dp[i] = aliceWin;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(winnerSquareGame(2));
    }
}
