package dsquestions.stacks;

import java.util.Stack;

public class ScoreOfParentheses {

    public static int scoreOfParentheses(String s) {

        int score = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.add(-1);
            } else {
                int count = 0;
                while (stack.peek() != -1) {
                    count += stack.pop();
                }
                stack.pop();
                stack.add(Math.max(2 * count, 1));
            }
        }
        while (!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(())"));
    }
}
