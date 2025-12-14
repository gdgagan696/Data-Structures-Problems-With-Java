package dsquestions.stacks;

import java.util.Stack;

public class MaxChunks {

    public static int maxChunksToSorted(int[] arr) {
        boolean isDesc=true;
        for (int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                isDesc=false;
                break;
            }
        }
        if(isDesc){
            return 1;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() < arr[i] || Math.abs(stack.peek()-arr[i])==1) {
                res++;
                stack.clear();
            }
            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(maxChunksToSorted(new int[]{0,1}));
    }

}
