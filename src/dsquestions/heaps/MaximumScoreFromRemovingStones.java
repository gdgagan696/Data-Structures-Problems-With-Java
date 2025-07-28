package dsquestions.heaps;

import java.util.PriorityQueue;

public class MaximumScoreFromRemovingStones {
    public static int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer>pq=new PriorityQueue<>((x,y)->y.compareTo(x));
        pq.add(a);
        pq.add(b);
        pq.add(c);
        int count=0;
        while (pq.size()>1){
            int x=pq.poll();
            int y=pq.poll();
            if(--x>0)
            pq.add(x);
            if(--y>0)
            pq.add(y);
            count++;
        }
        return count;
    }
    public static void main(String[]args){
        System.out.println(maximumScore(2,4,6));

    }
}
