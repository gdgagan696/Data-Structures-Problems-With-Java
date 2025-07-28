package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        Map<Integer,Integer> hm=new HashMap<>();
        for (int x:hand){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(hm.keySet());
        while (!pq.isEmpty()){
            int first=pq.peek();
            for(int i=first;i<first+groupSize;i++){
                if(!hm.containsKey(i)){
                    return false;
                }
                hm.put(i,hm.get(i)-1);
                if(hm.get(i)==0){
                    if(i!=pq.peek()){
                        return false;
                    }
                    pq.poll();
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3));
    }
}
