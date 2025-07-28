package dsquestions.arrays;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.add(1L);
        set.add(1L);
        int []factors={2,3,5};
        for (int i = 0; i < n; i++) {
            long num=pq.poll();
            if(i==n-1){
                return (int) num;
            }
            for (int f:factors){
                if(!set.contains(num*f)){
                    set.add(num*f);
                    pq.add(num*f);
                }
            }
        }
        return -1;

    }

}
