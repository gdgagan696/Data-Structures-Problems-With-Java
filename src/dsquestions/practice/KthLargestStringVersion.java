package dsquestions.practice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestStringVersion {

    public static String kthLargestNumber(String[] nums, int k) {
        Queue<String> pq = new PriorityQueue<>((a, b) -> {
            if (a.length() == b.length()) {
                if (a.compareTo(b) < 0) {
                    return 1;
                } else if (a.compareTo(b) > 0) {
                    return -1;
                }
                return 0;
            } else {
                return b.length() - a.length();
            }
        });
        pq.addAll(Arrays.asList(nums));
        String res = null;
        while (k-- > 0) {
            res = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] nums = {"3", "6", "7", "10"};
        System.out.println(kthLargestNumber(nums, 4));
    }
}
