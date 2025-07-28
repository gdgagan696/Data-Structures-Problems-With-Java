package dsquestions.strings;

import java.util.Arrays;
import java.util.HashMap;

public class StringWithOddCounts {

    public static String generateTheString(int n) {
        char[]result=new char[n];
        Arrays.fill(result,'a');
        if(n%2==0){
            result[0]='b';
        }
        return new String(result);

    }
    public static void main(String[]args){
        System.out.println(generateTheString(5));

    }
}
