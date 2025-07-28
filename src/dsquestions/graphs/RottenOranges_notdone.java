package dsquestions.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges_notdone {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j, 0});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if(fresh==0){
                return temp[2];
            }
            int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int[] dir : dirs) {
                int r = temp[0] + dir[0];
                int c = temp[1] + dir[1];
                if (Math.min(r, c) < 0 || r >= grid.length || c >= grid[0].length || grid[r][c]==0 || visited[r][c]) {
                    continue;
                }
                fresh--;
                queue.add(new int[]{r,c,temp[2]+1});
                grid[r][c]=2;
            }
        }
        return -1;

    }
}
