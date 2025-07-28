package dsquestions.stacks;

import java.util.Stack;

public class MaxScore {
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String high = x > y ? "ab" : "ba";
        String low = high.equals("ab") ? "ba" : "ab";

        String stringAfterFirstPass = getRemainingString(s, high);
        int removedPairsCount = (s.length() - stringAfterFirstPass.length()) / 2;

        totalScore += removedPairsCount * Math.max(x, y);

        String stringAfterSecondPass = getRemainingString(stringAfterFirstPass, low);
        removedPairsCount = (stringAfterFirstPass.length() -
                stringAfterSecondPass.length()) /
                2;

        totalScore += removedPairsCount * Math.min(x, y);
        return totalScore;

    }

    public String getRemainingString(String s, String sub) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == sub.charAt(1) && !stack.isEmpty() && stack.peek() == sub.charAt(0)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder remainingChars = new StringBuilder();
        while (!stack.isEmpty()) {
            remainingChars.append(stack.pop());
        }
        return remainingChars.reverse().toString();
    }
}
