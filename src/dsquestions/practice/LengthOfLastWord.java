package dsquestions.practice;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        s=s.trim();
        int i=s.length()-1;
        while (i>=0){
            if(s.charAt(i)==' '){
                break;
            }
            i--;
        }
        return s.length()-i-1;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
