package dsquestions.strings;

public class CountAndSay {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String result = "11";
        for (int i = 3; i <= n; i++) {
            int count = 1, j = 1;
            result = result + "@";
            String temp = "";
            for (; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    temp += count + "" + result.charAt(j - 1) + "";
                    count = 1;
                }
            }
            result = temp;
        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));

    }
}
