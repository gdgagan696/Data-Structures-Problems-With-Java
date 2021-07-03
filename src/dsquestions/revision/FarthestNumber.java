package dsquestions.revision;

import java.util.Arrays;
import java.util.Stack;

public class FarthestNumber {
    static int[] farNumber(int N, int Arr[])
    {
        Stack<Integer>stack=new Stack<>();
        int right[]=new int[N];
        right[N-1]=-1;
        stack.push(N-1);
        for(int i=N-2;i>=0;i--){
            while(stack.size()>0 && Arr[i]<Arr[stack.peek()]){
                stack.pop();
            }
            if(stack.empty()){
                right[i]=-1;
            }
            else {
                right[i]=stack.peek();
            }
            stack.add(i);
        }
        return right;
    }

    public static void main(String[]args){
        System.out.println(Arrays.toString(farNumber(5,new int[]{3,1,5,2,4})));
    }
}
