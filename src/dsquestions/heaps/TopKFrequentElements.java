package dsquestions.heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length) return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        for (int n : nums) {
            map.put(n,map.getOrDefault(n,0)+1);
        }
        Queue<Integer> temp = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        temp.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            result[i] = temp.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int nums[]={1,1,2,2,1,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }
}
