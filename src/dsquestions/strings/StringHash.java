package dsquestions.strings;

import java.util.ArrayList;
import java.util.List;

public class StringHash {

    public static String stringHash(String s, int k) {

        int n = s.length();
        List<String> subs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += k) {
            String temp = s.substring(i, i + k);
            subs.add(temp);
        }

        for (String str : subs) {
            int sum = 0;
            for (char ch : str.toCharArray()) {
                sum += ch - 'a';
            }
            sum = 'a' + sum % 26;
            sb.append((char) sum);
        }
        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(stringHash("abcd", 2));
    }

}
