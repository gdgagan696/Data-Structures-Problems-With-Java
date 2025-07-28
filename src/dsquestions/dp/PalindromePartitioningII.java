package dsquestions.dp;

import java.util.Arrays;

public class PalindromePartitioningII {

    public static int minCut(String s) {
        int dp[][]=new int[s.length()][s.length()];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return partition(s,0,s.length()-1,dp);
    }

    private static int  partition(String s, int i, int j,int[][]dp) {
        if(i>=j || isPalindrome(s,i,j)){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int temp=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int left=-1;
            int right=-1;
            if(dp[i][k]!=-1){
                left=dp[i][k];
            }
            else{
                left=partition(s,i,k,dp);
            }
            if(dp[k+1][j]!=-1){
                right=dp[k+1][j];
            }
            else{
                right=partition(s,k+1,j,dp);
            }
            int res=1+left+right;
            temp=Math.min(temp,res);
        }
        dp[i][j]=temp;
        return temp;
    }

    private static boolean isPalindrome(String s, int i, int j) {

        while (i<=j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        return i>j;
    }

    public static void main(String[]args){
        System.out.println(minCut("aab"));
    }
}
