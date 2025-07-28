package dsquestions.arrays;

import java.util.Arrays;

class BagOfTokens {
    public static int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int i = 0;
        int j = tokens.length - 1;
        Arrays.sort(tokens);
        while (i <= j) {
            if (power >= tokens[i]) {
                score++;
                power -= tokens[i++];
            } else {
                if (score >= 1 && i != j) {
                    score--;
                    power += tokens[j--];
                } else {
                    break;
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{100, 200, 300, 400}, 200));
    }
}
