package dsquestions.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            hm.put(nums2[i], i);
        }
        int[] nextGreater = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = hm.get(nums1[i]);
            res[i] = nextGreater[index];
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

}
