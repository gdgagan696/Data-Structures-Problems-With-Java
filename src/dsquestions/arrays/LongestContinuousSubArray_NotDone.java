package dsquestions.arrays;

import java.util.*;

public class LongestContinuousSubArray_NotDone {
    public static int longestSubarray(int[] nums, int limit) {
        int i = 0, j = 0;
        int res = 0;
        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();
        while (j < nums.length) {
            while (!minQ.isEmpty() && minQ.peekLast() > nums[j]) {
                minQ.pollLast();
            }
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[j]) {
                maxQ.pollLast();
            }
            minQ.add(nums[j]);
            maxQ.add(nums[j]);
            while (maxQ.peek()-minQ.peek()>limit){
                if(maxQ.peekFirst()==nums[i]){
                    maxQ.pollFirst();
                }
                if(minQ.peekFirst()==nums[i]){
                    minQ.pollFirst();
                }
                i++;
            }
            res=Math.max(res,j-i+1);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8, 2, 4, 7}, 4));
    }
}
