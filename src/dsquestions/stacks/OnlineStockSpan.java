package dsquestions.stacks;

import java.util.Stack;

public class OnlineStockSpan {

    Stack<int[]> stack;

    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            count += stack.pop()[1];
        }
        stack.push(new int[]{price, count});
        return count;
    }

    public static void main(String[] args) {
        OnlineStockSpan onlineStockSpan = new OnlineStockSpan();
        System.out.println(onlineStockSpan.next(100));
        System.out.println(onlineStockSpan.next(80));
        System.out.println(onlineStockSpan.next(60));
        System.out.println(onlineStockSpan.next(70));
        System.out.println(onlineStockSpan.next(65));
        System.out.println(onlineStockSpan.next(75));
        System.out.println(onlineStockSpan.next(85));
    }
}
