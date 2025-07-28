package dsquestions.graphs;

public class CountServers {

    public static int countServers(int[][] grid) {

        int count = 0;
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (row[i] > 1 || col[j] > 1)) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {

        int[][] grid = {
                {1, 0}, {1, 1}
        };
        System.out.println(countServers(grid));
    }

}
