package dsquestions.backtracking;

public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        boolean visited[][]=new boolean[obstacleGrid.length][obstacleGrid[0].length];
        return uniquePathsWithObstacles(obstacleGrid,visited,0,0);
    }

    private static int uniquePathsWithObstacles(int[][] obstacleGrid, boolean[][] visited, int row, int col) {
        if (row >= obstacleGrid.length || col >= obstacleGrid[0].length || visited[row][col] ||
            obstacleGrid[row][col]==1) {
            return 0;
        }
        if (row == obstacleGrid.length-1 && col == obstacleGrid[0].length-1) {
            return 1;
        }
        visited[row][col] = true;
        int total = 0;
        //right
        total += uniquePathsWithObstacles(obstacleGrid, visited, row, col + 1);
        visited[row][col]=false;
        //down
        total += uniquePathsWithObstacles(obstacleGrid, visited, row + 1, col);
        visited[row][col]=false;
        return total;
    }

    public static int uniquePathsWithObstacles_Dp(int[][] obstacleGrid) {
        int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--) {
                if (obstacleGrid[i][j] != 1) {
                    if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1){
                        dp[i][j]=1;
                    }
                    else if (i == dp.length - 1) {
                        dp[i][j]=dp[i][j+1];
                    }
                    else if (j == dp[0].length - 1) {
                        dp[i][j]=dp[i+1][j];
                    }
                    else{
                        dp[i][j]=dp[i+1][j]+dp[i][j+1];
                    }
                }
            }

        }
        return dp[0][0];
    }

    public static void main(String[]args){
        int [][]grid={
                {0,0,0},{0,1,0},{0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(grid));
        System.out.println(uniquePathsWithObstacles_Dp(grid));
    }
}
