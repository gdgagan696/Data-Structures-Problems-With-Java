package dsquestions.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeHappiness {
    public static long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : happiness) {
            pq.add(x);
        }
        long score = 0;
        int diff = 0;
        while (k-- > 0) {
            int temp = pq.poll() - diff;
            if (temp < 0) continue;
            score += temp;
            diff++;
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[]{1, 2, 3}, 2));
        System.out.println(maximumHappinessSum(new int[]{1, 1, 1, 1}, 2));
    }
}
