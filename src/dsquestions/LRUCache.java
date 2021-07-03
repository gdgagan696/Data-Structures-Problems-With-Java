package dsquestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> hm;
    Deque<Integer> deque;
    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        deque = new ArrayDeque<>();
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            deque.remove(key);
            deque.addFirst(key);
            return hm.get(key);
        }
        return -1;

    }

    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            deque.remove(key);
            hm.remove(key);
        }
        if (hm.size() == capacity) {
            int removedKey = deque.removeLast();
            hm.remove(removedKey);
        }
        hm.put(key, value);
        deque.addFirst(key);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));
    }
}
