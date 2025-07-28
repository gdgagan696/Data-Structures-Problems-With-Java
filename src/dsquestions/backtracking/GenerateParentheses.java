package dsquestions.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int open = n, close = n;
        generateParenthesis("", open, close, result);
        return result;

    }

    private static void generateParenthesis(String str, int open, int close, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(str);
        }
        if (open != 0) {
            String op1 = str + "(";
            generateParenthesis(op1, open - 1, close, result);
        }
        if (open < close) {
            String op1 = str + ")";
            generateParenthesis(op1, open, close - 1, result);

        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

    }
}
