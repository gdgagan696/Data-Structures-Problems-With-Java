package dsquestions.dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>>result=new ArrayList<>();
        partition(s,0,s.length()-1,result);
        return result;
    }

    private static void partition(String s, int i, int j,List<List<String>>result) {
        if(i>=j){
            return;
        }
        if(isPalindrome(s,i,j)){
            List<String>temp=new ArrayList<>();
            temp.add(s.substring(i,j));
            result.add(temp);
            return;
        }
        for(int k=i;k<j;k++){
            partition(s,i,k,result);
            partition(s,k+1,j,result);
        }
    }

    private static boolean isPalindrome(String s, int i, int j) {

        while (i<=j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        return i>j;
    }

    public static void main(String[]args){
        System.out.println(partition("aab"));
    }
}
