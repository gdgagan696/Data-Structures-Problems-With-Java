package dsquestions.graphs;

import java.util.ArrayList;
import java.util.List;

public class GroupsOfFarmland {
    public static int[][] findFarmland(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        List<int[]> res = new ArrayList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] curr = new int[4];
                    curr[0] = i;
                    curr[1] = j;
                    curr[2] = i;
                    curr[3] = j;
                    res.add(curr);
                    findFarmlandUtil(land, i, j, visited, curr);
                }
            }
        }
        return res.toArray(int[][]::new);

    }

    private static void findFarmlandUtil(int[][] land, int i, int j, boolean[][] visited, int[] curr) {
        if (i >= land.length || i < 0 || j >= land[0].length || j < 0 || land[i][j] == 0) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (curr[0] > i || curr[1] > j) {
            curr[0] = i;
            curr[1] = j;
        }
        if (curr[2] < i || curr[3] < j) {
            curr[2] = i;
            curr[3] = j;
        }
        findFarmlandUtil(land, i, j + 1, visited, curr);
        findFarmlandUtil(land, i, j - 1, visited, curr);
        findFarmlandUtil(land, i + 1, j, visited, curr);
        findFarmlandUtil(land, i - 1, j, visited, curr);
    }

    public static void main(String[] args) {
        int [][]land={
                {1,0,0},
                {0,1,1,},
                {0,1,1}
        };
        int [][]land2={
                {1,1},
                {0,0},
        };
        System.out.println(findFarmland(land2));
    }

}
