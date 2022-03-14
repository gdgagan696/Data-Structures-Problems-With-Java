package dsquestions.strings;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] splitPath = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : splitPath) {
            if (str.length() > 0 && (str.equals("/") || str.equals("."))) {
                continue;
            } else if (str.length() > 0 && str.equals("..") && stack.size() > 0) {
                stack.pop();
            } else if (str.length() > 0 && !str.equals("..")) {
                stack.add(str);
            }

        }
        String res = "/";
        res += String.join("/", stack);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/..."));
    }
}
