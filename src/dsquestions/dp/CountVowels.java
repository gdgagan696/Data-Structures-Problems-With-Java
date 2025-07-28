package dsquestions.dp;

public class CountVowels {
    public static int countVowelPermutation(int n) {
        int mat[][] = {
                {1}, {0, 2},
                {0, 1, 3, 4}, {2, 4},
                {0}
        };
        long ans = 0;
        long mod = (long) (Math.pow(10, 9)) + 7;
        long dp[][] = new long[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int v : mat[j]) {
                    dp[i][j] += dp[i - 1][v] % mod;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            ans = (ans + dp[n][i]) % mod;
        }
        return (int) ans;

    }

    public static void main(String[] args) {
        System.out.println(countVowelPermutation(144));
    }
}
