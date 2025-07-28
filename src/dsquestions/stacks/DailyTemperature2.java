package dsquestions.stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature2 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{temperatures[0], 0});
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] temp = stack.pop();
                res[temp[1]] = i - temp[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}

