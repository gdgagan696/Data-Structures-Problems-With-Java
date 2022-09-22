package dsquestions.Dsstudy1;

public class ReverseStringII {

    public static String reverseWords(String s) {
        String[] sArr = s.split(" ");

        for (int i=0;i<sArr.length;i++) {
            sArr[i]=reverseString(sArr[i].toCharArray());
        }
        return String.join(" ",sArr);
    }

    public static String reverseString(char[] s) {

        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
        return new String(s);
    }

    public static void main(String[]args){
        System.out.println(reverseWords("God Ding"));
    }

}
