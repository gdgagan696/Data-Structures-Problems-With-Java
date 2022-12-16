package dsquestions.queues;

import java.util.Stack;

class MyQueue {

    /**
     * Initialize your data structure here.
     */
    Stack<Integer> s1;
    Stack<Integer> s2;
    int size;

    public MyQueue() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
        this.size = 0;

    }

    public void push(int x) {
        s1.push(x);
        size++;

    }

    public int pop() {
        peek();
        size--;
        return s2.pop();

    }

    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) return -1;
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();

    }

    public boolean empty() {
        return size == 0;

    }
}