package dsquestions.strings;

public class RemovePalindromicSubsequences {

    public static int removePalindromeSub(String s) {
        if(s==null || s.length()==0){
            return  0;
        }
        if(isPalindrome(s)){
            return 1;
        }
        return 2;

    }
    private static boolean isPalindrome(String s) {
        if (new StringBuilder(s).reverse().toString().equals(s)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(removePalindromeSub("ababa"));
    }

}
