package dsquestions.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class NumberOfAtoms {
    public static String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            if (ch == '(') {
                stack.push(new HashMap<>());
            } else if (ch == ')') {
                Map<String, Integer> current = stack.pop();
                Map<String, Integer> prev = stack.peek();
                String count = "";
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    count += formula.charAt(i + 1);
                    i++;
                }
                int parseCount = count.equals("") ? 1 : Integer.parseInt(count);
                for (String key : current.keySet()) {
                    current.put(key, current.get(key) * parseCount);
                    prev.put(key, prev.getOrDefault(key, 0) + current.get(key));
                }
            } else {
                String element = ch + "";
                while (i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))) {
                    element += formula.charAt(i + 1);
                    i++;
                }
                String count = "";
                while (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    count += formula.charAt(i + 1);
                    i++;
                }
                int parseCount = count.equals("") ? 1 : Integer.parseInt(count);
                Map<String, Integer> hm = stack.peek();
                hm.put(element, hm.getOrDefault(element, 0) + parseCount);
            }
        }
        Map<String, Integer> current = stack.pop();
        String res = "";
        for (String key : current.keySet()) {
            String count = current.get(key) > 1 ? current.get(key) + "" : "";
            res += key + count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countOfAtoms("H11He49NO35B7N46Li20"));
    }
}
