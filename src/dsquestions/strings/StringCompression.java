package dsquestions.strings;

public class StringCompression {
    public static int compress(char[] chars) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            res.append(chars[i]);
            int count = 1;
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {
                i++;
                count++;
            }
            i++;

            if (count > 1) {
                res.append(count);
            }
        }
        for (i = 0; i < res.length(); i++) {
            chars[i] = res.charAt(i);
        }
        return res.length();
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
}
