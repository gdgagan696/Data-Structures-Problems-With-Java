package dsquestions.stacks;

import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int size;

    public QueueUsingStacks() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
        this.size = 0;
    }

    public void push(int x) {
        s1.push(x);
        size++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        peek();
        size--;
        return s2.pop();

    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) return -1;
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return size == 0;

    }

    public static void main(String[] args) {
        QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
        queueUsingStacks.push(1);
        queueUsingStacks.push(2);
        System.out.println(queueUsingStacks.peek());
        System.out.println(queueUsingStacks.pop());
        System.out.println(queueUsingStacks.empty());
    }

}
