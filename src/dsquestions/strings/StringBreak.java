package dsquestions.strings;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringBreak {

    public static boolean checkIfCanBreak(String s1, String s2) {

        String sorted1 =
                Stream.of(s1.split(""))
                        .sorted()
                        .collect(Collectors.joining());
        String sorted2 =
                Stream.of(s2.split(""))
                        .sorted()
                        .collect(Collectors.joining());

        int i = 0;
        boolean res1 = true;
        while (i < s1.length()) {
            if (sorted1.charAt(i) >= sorted2.charAt(i)) {
                i++;
            } else {
                res1 = false;
                break;
            }
        }
        if (!res1) {
            i = 0;
            while (i < s1.length()) {
                if (sorted2.charAt(i) >= sorted1.charAt(i)) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {

        System.out.println(checkIfCanBreak("abc", "xya"));

    }

}
