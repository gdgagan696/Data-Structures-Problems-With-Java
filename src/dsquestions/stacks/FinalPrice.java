package dsquestions.stacks;

import java.util.Arrays;
import java.util.Stack;

public class FinalPrice {

    public static int[] finalPrices(int[] prices) {

        int[] res = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = res.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            int discount = stack.isEmpty() ? 0 : stack.peek();
            res[i] = prices[i] - discount;
            stack.push(prices[i]);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(finalPrices(new int[]{8, 4, 6, 2, 3})));

    }

}
