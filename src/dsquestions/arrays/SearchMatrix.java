package dsquestions.arrays;

public class SearchMatrix {

    private boolean searchMatrix(int[][] matrix, int target) {

        boolean isFound = false;
        for (int i = 0; i < matrix.length; i++) {
            isFound = binarySearch(matrix[i], target);
            if (isFound) {
                return isFound;
            }
        }
        return isFound;

    }

    private boolean binarySearch(int[] matrix, int target) {
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

    public static void main(String[] args) {

    }
}
