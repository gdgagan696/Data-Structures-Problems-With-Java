package dsquestions.queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecentCounter {
    int count;
    List<Integer> list;
    Queue<Integer>queue;

    public RecentCounter() {
        count = 0;
        list = new ArrayList<>();
        queue=new LinkedList<>();

    }

    public int ping(int t) {
        int l = t - 3000;
        list.add(t);
        count++;
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i) >= l) {
                break;
            }
        }
        return count - i;
    }

    public int ping_Queue(int t) {
        int l = t - 3000;
        queue.add(t);
        while (queue.peek()<l){
            queue.poll();
        }
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));

        System.out.println(recentCounter.ping_Queue(1));
        System.out.println(recentCounter.ping_Queue(100));
        System.out.println(recentCounter.ping_Queue(3001));
        System.out.println(recentCounter.ping_Queue(3002));

    }
}
