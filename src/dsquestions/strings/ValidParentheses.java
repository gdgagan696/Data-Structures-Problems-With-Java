package dsquestions.strings;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        if(s.isEmpty())return true;
        Stack<Character>stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }
            else if(stack.size()>0){
                if(ch==')' && stack.peek()=='(') {
                    stack.pop();
                }
                if(ch==']' && stack.peek()=='[') {
                    stack.pop();
                }
                if(ch=='}' && stack.peek()=='{') {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));

    }
}
