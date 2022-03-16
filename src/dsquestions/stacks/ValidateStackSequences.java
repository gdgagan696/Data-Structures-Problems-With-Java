package dsquestions.stacks;

import java.util.Stack;

public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.add(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {2, 1, 0};
        int[] popped = {1, 2, 0};
        System.out.println(validateStackSequences(pushed, popped));
    }
}
