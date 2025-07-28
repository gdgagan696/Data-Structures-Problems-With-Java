package dsquestions.graphs;

public class CountSubIslands {

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && isSubIsland(grid1, grid2, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean isSubIsland(int[][] grid1, int[][] grid2, int i, int j) {

        if (i >= grid1.length || i < 0 || j >= grid1[0].length || j < 0 || grid2[i][j] != 1) {
            return true;
        }
        grid2[i][j]=-1;
        boolean result = (grid1[i][j] == 1);
        result = result &isSubIsland(grid1, grid2, i, j + 1);
        result = result & isSubIsland(grid1, grid2, i, j - 1);
        result = result & isSubIsland(grid1, grid2, i + 1, j);
        result = result & isSubIsland(grid1, grid2, i - 1, j);
        return result;
    }


    public static void main(String[] args) {

        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}},
                grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        System.out.println(countSubIslands(grid1, grid2));
    }

}
