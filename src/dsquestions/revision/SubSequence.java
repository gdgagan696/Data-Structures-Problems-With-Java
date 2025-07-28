package dsquestions.revision;

import java.util.Arrays;

public class SubSequence {

    private static String[] subSequence(String str){

        if(str.length()==0){
            return new String[]{""};
        }
        String[]remaining=subSequence(str.substring(1));
        String[]result=new String[2*remaining.length];
        int i=0;
        for(String word:remaining){
            result[i++]=word;
        }
        for(String word:remaining){
            result[i++]=str.charAt(0)+word;
        }
        return result;
    }

    public static void main(String[]args){
        System.out.println(Arrays.toString(subSequence("abc")));

    }
}
