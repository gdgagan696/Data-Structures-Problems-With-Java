package dsquestions.strings;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesStringII {
    static class Pair {
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public static String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }
        Stack<Pair> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(new Pair(ch, 1));
            } else {
                Pair top = stack.peek();
                if (top.ch == ch) {
                    top.count += 1;
                    if (top.count == k) {
                        stack.pop();
                    } else {
                        stack.pop();
                        stack.push(top);
                    }
                } else {
                    stack.push(new Pair(ch, 1));
                }
            }
        }
        while (stack.size() > 0) {
            Pair top = stack.pop();
            for (int i = 0; i < top.count; i++) {
                result.append(top.ch + "");
            }
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
