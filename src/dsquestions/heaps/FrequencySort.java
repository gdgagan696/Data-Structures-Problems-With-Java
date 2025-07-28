package dsquestions.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static String frequencySort(String s) {
        Map<Character,Integer> hm=new HashMap<>();
        for(char ch:s.toCharArray()){
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>>pq=new PriorityQueue<>(
                (a,b)->a.getValue()==b.getValue()?a.getKey().compareTo(b.getKey()):b.getValue()-a.getValue());

        pq.addAll(hm.entrySet());
        String res="";
        while (!pq.isEmpty()){
            String temp="";
            Map.Entry<Character,Integer>entry=pq.poll();
            for(int i=0;i<entry.getValue();i++){
                temp+=entry.getKey();
            }
            res+=temp;
        }
        return res;
    }

    public static void main(String[]args){
        System.out.println(frequencySort("Aabb"));

    }
}
