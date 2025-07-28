package dsquestions.strings;

public class FirstPalindromicString {
    public static String firstPalindrome(String[] words) {  
        for (String word : words) {
            if (new StringBuilder(word).reverse().toString().equals(word)) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"def","ghi"}));
    }
}
