package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class FormTeam {
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 0; i < rating.length; i++) {
            for (int j = i + 1; j < rating.length; j++) {
                for (int k = j + 1; k < rating.length; k++) {
                    if (rating[i] > rating[j] && rating[j] > rating[k]) {
                        res++;
                    }
                    if (rating[i] < rating[j] && rating[j] < rating[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static int numTeamsDP(int[] rating) {
        Integer[][][] dp = new Integer[rating.length][2][4];
        int count = 0;
        for (int i = 0; i < rating.length; i++) {
            count += numTeamsDP(rating, i, 1, dp, 1);
            count += numTeamsDP(rating, i, 0, dp, 1);
        }
        return count;
    }

    private static int numTeamsDP(int[] rating, int i, int asc, Integer[][][] dp, int count) {

        if (i >= rating.length) {
            return 0;
        }
        if (dp[i][asc][count] != null) {
            return dp[i][asc][count];
        }
        if (count == 3) {
            return 1;
        }
        int res = 0;
        for (int j = i + 1; j < rating.length; j++) {
            if (asc == 1 && rating[i] < rating[j]) {
                res += numTeamsDP(rating, j , asc, dp, count + 1);
            }
            if (asc == 0 && rating[i] > rating[j]) {
                res += numTeamsDP(rating, j, asc, dp, count + 1);
            }
        }
        dp[i][asc][count] = res;
        return res;
    }

    public static void main(String[] args) {
        int[] ratings = {2, 5, 3, 4, 1};
        System.out.println(numTeamsDP(ratings));
    }
}
