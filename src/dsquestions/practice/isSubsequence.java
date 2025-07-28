package dsquestions.practice;

public class isSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int i=0;
        int j=0;
        while (i<t.length()){
            if(j<s.length() && s.charAt(j)==t.charAt(i)){
                j++;
            }
            i++;
        }
        return j==s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc","ahbgdc"));
    }
}
