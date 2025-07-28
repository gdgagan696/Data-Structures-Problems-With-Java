package dsquestions.revision;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIII {

    public static int[] nextGreaterElements(int[] nums) {
        int n = 2 * nums.length;
        Stack<Integer> s1 = new Stack<>();
        int result[] = new int[nums.length];
        for (int i = n - 1; i >= 0; i--) {
            while (s1.size() > 0 && nums[i % nums.length] >= nums[s1.peek()]) {
                s1.pop();
            }
            if (s1.size() == 0) {
                result[i % nums.length] = -1;
            } else {
                result[i % nums.length] = nums[s1.peek()];
            }
            s1.push(i % nums.length);
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 3, 4, 3})));

    }
}
