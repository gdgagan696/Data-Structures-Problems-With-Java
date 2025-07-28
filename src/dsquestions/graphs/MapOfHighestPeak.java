package dsquestions.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

    public static int[][] highestPeak(int[][] isWater) {

        int mat[][] = new int[isWater.length][isWater[0].length];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[0].length; j++) {
                if (isWater[i][j] == 1) {
                    mat[i][j] = 0;
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < isWater.length && newCol >= 0 && newCol < isWater[0].length
                        && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    mat[newRow][newCol] = mat[row][col]+1;
                    queue.add(new int[]{newRow,newCol});
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {

        int[][] isWater = {{0,0,1},{1,0,0},{0,0,0}};
        int[][] res = highestPeak(isWater);
        System.out.println(Arrays.toString(res));

    }

}
