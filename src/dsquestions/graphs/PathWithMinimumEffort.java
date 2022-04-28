package dsquestions.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
    public int minimumEffortPath(int[][] heights) {
        final int rows = heights.length;
        final int cols = heights[0].length;
        final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean visited[][] = new boolean[rows][cols];
        int[][] minDiff = new int[rows][cols];
        for (int[] b : minDiff)
            Arrays.fill(b, Integer.MAX_VALUE);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt((int[] v) -> v[2]));
        minDiff[0][0] = 0;
        queue.add(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] vertex = queue.remove();
            if (visited[vertex[0]][vertex[1]])
                continue;
            int effort = vertex[2];
            if (vertex[0] == rows - 1 && vertex[1] == cols - 1)
                return effort;
            visited[vertex[0]][vertex[1]] = true;
            for (int[] temp : dir) {
                int row = vertex[0] + temp[0];
                int col = vertex[1] + temp[1];
                if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]) {
                    int tempEffort = Math.max(effort, Math.abs(heights[row][col] - heights[vertex[0]][vertex[1]]));
                    if (tempEffort < minDiff[row][col]) {
                        minDiff[row][col] = tempEffort;
                        queue.add(new int[]{row, col, tempEffort});
                    }
                }
            }
        }
        return 0;
    }
}



