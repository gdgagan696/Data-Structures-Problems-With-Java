package dsquestions.strings;

public class ReverseDegree {
    public static int reverseDegree(String s) {

        int res=0;
        for (int i=0;i<s.length();i++){
            res+=(26-(s.charAt(i)-'a'))*(i+1);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(reverseDegree("abc"));
    }

}
