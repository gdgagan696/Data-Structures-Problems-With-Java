package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstPaintedRow {

    public static int firstCompleteIndex(int[] arr, int[][] mat) {

        Map<Integer, Integer[]> hm = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                hm.put(mat[i][j], new Integer[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            Integer[] pos = hm.get(arr[i]);
            mat[pos[0]][pos[1]] = -1;
            if (isValid(mat)) {
                return i;
            }
        }
        return -1;
    }

    public static int firstCompleteIndexOptimised(int[] arr, int[][] mat) {

        Map<Integer, Integer[]> hm = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                hm.put(mat[i][j], new Integer[]{i, j});
            }
        }
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        for (int i = 0; i < arr.length; i++) {
            Integer[] pos = hm.get(arr[i]);
            rows[pos[0]]++;
            cols[pos[1]]++;
            if (rows[pos[0]] == mat[0].length) {
                return i;
            }
            if (cols[pos[1]] == mat.length) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isValid(int[][] mat) {

        for (int[] row : mat) {
            int count = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] == -1) {
                    count++;
                }
            }
            if (count == mat[0].length) {
                return true;
            }
        }
        for (int i = 0; i < mat[0].length; i++) {
            int count = 0;
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][i] == -1) {
                    count++;
                }
            }
            if (count == mat.length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] arr = {2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] mat = {{3, 2, 5}, {1, 4, 6}, {8, 7, 9}};
//        System.out.println(firstCompleteIndex(arr,mat));
        System.out.println(firstCompleteIndexOptimised(arr, mat));
    }

}
