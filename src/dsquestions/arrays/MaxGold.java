package dsquestions.arrays;

public class MaxGold {
    public static int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    max = Math.max(max, getMaximumGoldUtil(grid, i, j, visited));
                }
            }
        }
        return max;
    }

    private static int getMaximumGoldUtil(int[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        visited[i][j] = true;
        int op1 = getMaximumGoldUtil(grid, i + 1, j, visited);
        int op2 = getMaximumGoldUtil(grid, i - 1, j, visited);
        int op3 = getMaximumGoldUtil(grid, i, j + 1, visited);
        int op4 = getMaximumGoldUtil(grid, i, j - 1, visited);
        int temp = grid[i][j] + Math.max(op1, Math.max(op2, Math.max(op3, op4)));
        visited[i][j] = false;
        return temp;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };
        System.out.println(getMaximumGold(grid));
    }
}
