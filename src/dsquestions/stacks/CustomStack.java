package dsquestions.stacks;

import java.util.Stack;

public class CustomStack {
    int maxSize;
    Stack<Integer>stack;
    public CustomStack(int maxSize) {
        this.maxSize=maxSize;
        this.stack=new Stack<>();
    }

    public void push(int x) {
        if(stack.size()<maxSize){
            stack.push(x);
        }

    }

    public int pop() {
        return stack.isEmpty()?-1:stack.pop();
    }

    public void increment(int k, int val) {
        Stack<Integer>temp=new Stack<>();
        if(stack.size()<k){
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            while (!temp.isEmpty()){
                stack.push(temp.pop()+val);
            }
        }
        else{
            int diff=stack.size()-k;
            Stack<Integer>modifiedValue=new Stack<>();
            while (diff-->0){
                temp.push(stack.pop());
            }
            while (!stack.isEmpty()){
                modifiedValue.push(stack.pop());
            }
            while (!modifiedValue.isEmpty()){
                stack.push(modifiedValue.pop()+val);
            }
            while (!temp.isEmpty()){
                stack.push(temp.pop());
            }
        }
    }


    public static void main(String[]args){
        CustomStack customStack=new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        System.out.println(customStack.pop());
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5,100);
        customStack.increment(2,100);
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
        System.out.println(customStack.pop());
    }
}
