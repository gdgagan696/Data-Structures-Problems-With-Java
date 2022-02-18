package dsquestions.strings;

import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {

        Stack<Character>stack=new Stack<>();
        StringBuilder result=new StringBuilder();
        for(int i=0;i<num.length();i++){
            while (stack.size()>0 && k>0 && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            if(stack.size()>0 || num.charAt(i)!='0'){
                stack.push(num.charAt(i));
            }
        }
        while (stack.size()>0 && k-->0){
            stack.pop();
        }
        if(stack.size()==0)return "0";
        while (stack.size()>0){
            result.append(stack.pop()+"");
        }
        return result.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",3));
    }
}
