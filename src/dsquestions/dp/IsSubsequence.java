package dsquestions.dp;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {

        int lcs=LCS(s,t);
        return lcs==s.length();
    }

    public static int LCS(String s, String t){
        int dp[][]=new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++){
            for (int j=0;j< dp[i].length;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
                else {
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                    }
                    else {
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[]args){
        System.out.println(isSubsequence("abc","ahbgdc"));
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
