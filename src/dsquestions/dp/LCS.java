package dsquestions.dp;

public class LCS {
    public static int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return longestCommonSubsequence(text1,text2,text1.length(),text2.length(),dp);

    }

    public static int longestCommonSubsequence(String text1, String text2,int m,int n,int [][]dp) {
        if(m==0 || n==0)return 0;
        if(dp[m][n]!=-1)return dp[m][n];
        if(text1.charAt(m-1)==text2.charAt(n-1)){
            int ans=1+longestCommonSubsequence(text1,text2,m-1,n-1,dp);
            dp[m][n]=ans;
        }
        else {
            int ans=Math.max(longestCommonSubsequence(text1,text2,m-1,n,dp),
                    longestCommonSubsequence(text1,text2,m,n-1,dp));
            dp[m][n]=ans;
        }
        return dp[m][n];
    }

    public static int longestCommonSubsequence_TopDown(String text1, String text2) {
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[]args){
        System.out.print(longestCommonSubsequence("abcde","ace"));
    }
}
