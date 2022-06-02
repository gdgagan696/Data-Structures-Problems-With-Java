package dsquestions.arrays;

public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] result = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int matrix[][] = {
                {2, 4, -1}, {-10, 5, 11}, {18, -7, 6}
        };
        matrix = transpose(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
