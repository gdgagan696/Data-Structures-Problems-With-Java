package dsquestions.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class RemoveStars {

    public static String removeStars(String s) {

        StringBuilder sb = new StringBuilder();
        Stack<Character>stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' && !stack.isEmpty()) {
                stack.pop();
            }
            if(s.charAt(i)!='*'){
                stack.add(s.charAt(i));
            }
        }
        while (stack.size()>0) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(removeStars("erase*****"));
    }

}
