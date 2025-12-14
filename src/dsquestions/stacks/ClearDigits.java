package dsquestions.stacks;

import java.util.Stack;

public class ClearDigits {
    public static String clearDigits(String s) {
        Stack<Character>stack=new Stack<>();
        for (char ch:s.toCharArray()){
            if(!Character.isDigit(ch)){
                stack.push(ch);
            }
            else {
                stack.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(clearDigits("cb34"));
    }

}
