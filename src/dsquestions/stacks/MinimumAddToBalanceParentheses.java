package dsquestions.stacks;

//Wihtout Stack
public class MinimumAddToBalanceParentheses {
    public static int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') open++;
            if (ch == ')') {
                if (open > 0) open--;
                else close++;
            }
            ;
        }
        return open + close;
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
    }
}
