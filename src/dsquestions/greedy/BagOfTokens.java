package dsquestions.greedy;

import java.util.Arrays;

public class BagOfTokens {
    public static int bagOfTokensScore(int[] tokens, int power) {
        int tempScore = 0;
        int resultantScore = 0;
        int i = 0;
        int j = tokens.length - 1;
        Arrays.sort(tokens);
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i++];
                resultantScore = Math.max(++tempScore, resultantScore);
            } else if (tempScore >= 1) {
                tempScore--;
                power += tokens[j--];
            } else {
                break;
            }


        }
        return resultantScore;
    }

    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{100}, 50));
        System.out.println(bagOfTokensScore(new int[]{100, 200}, 150));
        System.out.println(bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }
}
