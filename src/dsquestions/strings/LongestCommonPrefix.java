package dsquestions.strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String a=strs[0];
        String b=strs[strs.length-1];
        int i=0;
        String res="";
        while (i<a.length()&& i<b.length() && a.charAt(i)==b.charAt(i)){
            res+=a.charAt(i)+"";
            i++;
        }
        return res;
    }


    public static void main(String[]args){
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));

    }
}
