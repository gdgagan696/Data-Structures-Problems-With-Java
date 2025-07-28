package dsquestions.stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer>stack=new Stack<>();
        int[]result=new int[T.length];
        stack.push(T.length-1);
        result[T.length-1]=0;
        for(int i=T.length-2;i>=0;i--){
            while (stack.size()>0 && T[stack.peek()]<=T[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[i]=0;
            }
            else{
                result[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[]args){
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
