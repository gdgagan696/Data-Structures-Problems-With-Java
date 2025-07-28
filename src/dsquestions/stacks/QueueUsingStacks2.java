package dsquestions.stacks;

import java.util.Stack;

public class QueueUsingStacks2 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueUsingStacks2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        QueueUsingStacks2 queueUsingStacks2 = new QueueUsingStacks2();
        queueUsingStacks2.push(1);
        queueUsingStacks2.push(2);
        System.out.println(queueUsingStacks2.peek());
    }
}
