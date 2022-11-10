package dsquestions.stacks;

import java.util.Stack;

public class RemoveDuplicates {

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        stack.add(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (stack.size()>0 && stack.peek() == ch) {
                while (stack.size() > 0 && stack.peek() == ch) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }
        if (stack.size() > 0) {
            StringBuilder sb = new StringBuilder();
            while (stack.size() > 0) {
                sb.append(stack.pop() + "");
            }
            return sb.reverse().toString();
        }
        return "";
    }

    public static void main(String[]args){
        System.out.println(removeDuplicates("abbaca"));
    }
}
