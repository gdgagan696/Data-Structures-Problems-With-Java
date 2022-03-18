package dsquestions.strings;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {

        int[] lastIndex = new int[26];
        boolean visited[] = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!visited[ch - 'a']) {
                while (stack.size() > 0 && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                    visited[stack.pop() - 'a'] = false;
                }
                visited[ch - 'a'] = true;
                stack.add(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        while (stack.size() > 0) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }
}
