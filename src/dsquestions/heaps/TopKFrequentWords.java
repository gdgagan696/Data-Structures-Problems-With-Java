package dsquestions.heaps;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> hm = new TreeMap<>();
        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
                (a, b) -> hm.get(a) == hm.get(b) ? a.compareTo(b) : hm.get(b) - hm.get(a));
        pq.addAll(hm.keySet());
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                result.add(pq.poll());
            }
        }
        return result;

    }
}
