package dsquestions.strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ConstructStringWithRepeatLimit {

    public static String repeatLimitedString(String s, int repeatLimit) {

        Map<Character, Integer> hm = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        pq.addAll(hm.keySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            if (hm.get(ch) <= 0) {
                continue;
            }
            int val = Math.min(hm.get(ch), repeatLimit);
            while (val-- > 0) {
                sb.append(ch + "");
            }
            int diff = hm.get(ch) - repeatLimit;
            if (diff > 0 && pq.size() > 0 && hm.getOrDefault(pq.peek(), 0) > 0) {
                sb.append(pq.peek() + "");
                hm.put(pq.peek(), hm.get(pq.peek()) - 1);
                if (hm.get(pq.peek()) <= 0) {
                    hm.remove(pq.peek());
                    pq.poll();
                }
                pq.add(ch);
            }
            hm.put(ch, diff);
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        System.out.println(repeatLimitedString("cczazcc", 3));

    }


}
