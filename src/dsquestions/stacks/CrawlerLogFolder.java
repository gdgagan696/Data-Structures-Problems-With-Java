package dsquestions.stacks;

import java.util.Stack;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            String temp = log.substring(0, log.length() - 1);
            if(temp.equals("."))continue;
            if (temp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(temp);
            }
        }
        return stack.size();

    }
}
