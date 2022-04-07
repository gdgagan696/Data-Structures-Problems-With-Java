package dsquestions.arrays;

import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : stones) {
            pq.add(x);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x != y) {
                pq.add(x - y);
            }
        }
        return pq.size() > 0 ? pq.poll() : 0;
    }

    public static void main(String[] args) {
        int stones[] = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(stones));
    }
}
