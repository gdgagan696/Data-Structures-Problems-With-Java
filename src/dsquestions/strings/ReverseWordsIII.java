package dsquestions.strings;

public class ReverseWordsIII {
    public static String reverseWords(String s) {
        String[] temp = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String str : temp) {
            result.append(new StringBuilder(str).reverse().toString()).append(" ");
        }
        return result.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println(reverseWords("God Ding"));
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("Gagan"));

    }
}
