package dsquestions.graphs;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res=0;
        for (int i = 0; i > grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return res;

    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == '0') {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
    }
}
