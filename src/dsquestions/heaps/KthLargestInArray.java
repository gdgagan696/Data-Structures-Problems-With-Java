package dsquestions.heaps;

import java.util.PriorityQueue;

public class KthLargestInArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(k);
        for(int x:nums){
            if(pq.size()<k){
                pq.add(x);
            }
            else if(pq.peek()<x){
                pq.poll();
                pq.add(x);
            }
        }
        return pq.peek();
    }
    public static int findKthLargest_2(int[] nums, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(k);
        for(int x:nums){
            if(pq.size()<k){
                pq.add(x);
            }
            else if(pq.peek()<x){
                pq.poll();
                pq.add(x);
            }
        }
        return pq.peek();
    }
    public static void main(String[]args){
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(findKthLargest_2(new int[]{3,2,1,5,6,4},2));
    }
}
