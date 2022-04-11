package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
            for (int j = 0; j < n; j++) {
                list.add(0);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int oldOneDIndex = ((i * n + j) + k) % total;
                result.get(oldOneDIndex / n).set(oldOneDIndex % n, grid[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        System.out.println(shiftGrid(mat, 4));
    }
}
