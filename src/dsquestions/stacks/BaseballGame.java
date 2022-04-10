package dsquestions.stacks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BaseballGame {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operations = new HashSet<>(Arrays.asList("+", "D", "C"));
        int totalScore = 0;
        for (String str : ops) {
            if (!operations.contains(str)) {
                stack.add(Integer.parseInt(str));
            } else {
                if (str.equals("+")) {
                    int x = stack.pop();
                    int y = stack.peek();
                    stack.add(x);
                    stack.add(x + y);
                } else if (str.equals("D")) {
                    stack.add(stack.peek() * 2);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            totalScore += stack.pop();
        }
        return totalScore;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

}
