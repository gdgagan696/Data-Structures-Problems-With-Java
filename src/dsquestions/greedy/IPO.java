package dsquestions.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < profits.length; i++) {
            pq.add(new int[]{capital[i], profits[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= w) {
                maxProfit.add(pq.poll()[1]);
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            w += maxProfit.poll();
        }
        return w;
    }

    public static void main(String[] args) {
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 2};
        System.out.println(findMaximizedCapital(3, 0, profits, capital));
    }
}
