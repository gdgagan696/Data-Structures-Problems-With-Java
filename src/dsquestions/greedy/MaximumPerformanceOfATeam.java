package dsquestions.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {
    public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = 1000000007;
        int[][] engineers = new int[n][2];

        for (int i = 0; i < n; i++)
            engineers[i] = new int[]{efficiency[i], speed[i]};

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long result = Integer.MIN_VALUE, speedSum = 0;

        for (int[] engineer : engineers) {
            if (pq.size() == k)
                speedSum -= pq.poll();

            pq.add(engineer[1]);
            speedSum = speedSum + engineer[1];

            result = Math.max(result, speedSum * engineer[0]);
        }

        return (int) (result % MOD);
    }

    public static void main(String[] args) {
        int n = 6;
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        int k = 2;
        System.out.println(maxPerformance(n, speed, efficiency, k));

    }
}
