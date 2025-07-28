package dsquestions.stacks;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int i = 0;
                int sum = 0;
                while (i++ < 2) {
                    sum += Integer.parseInt(stack.pop());
                }
                stack.push(String.valueOf(sum));
            } else if (str.equals("-")) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num2 - num1));

            } else if (str.equals("*")) {
                int i = 0;
                int mul = 1;
                while (i++ < 2) {
                    mul *= Integer.parseInt(stack.pop());
                }
                stack.push(String.valueOf(mul));
            } else if (str.equals("/")) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(num2 / num1));
            } else {
                stack.push(str);
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] input = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(input));
    }

}
