package dsquestions.arrays;

public class SearchMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {

        boolean isFound = false;
        for (int i = 0; i < matrix.length; i++) {
            isFound = binarySearch(matrix[i], target);
            if (isFound) {
                return isFound;
            }
        }
        return isFound;

    }

    private static boolean binarySearch(int[] matrix, int target) {
        int l = 0;
        int h = matrix.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (matrix[mid] == target) {
                return true;
            } else if (matrix[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return false;

    }

    public static boolean searchMatrix_2(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int mat[][] = {
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        System.out.println(searchMatrix_2(mat, 3));

    }
}
