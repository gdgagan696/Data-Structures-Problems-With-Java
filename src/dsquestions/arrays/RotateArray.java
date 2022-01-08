package dsquestions.arrays;

public class RotateArray {
    public static void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[i].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            int j=0;
            int k=matrix[i].length;
            while (j<k){
                matrix[i][j]=matrix[i][j]^matrix[i][k];
                matrix[i][k]=matrix[i][j]^matrix[i][k];
                matrix[i][j]=matrix[i][j]^matrix[i][k];
                j++;
                k--;
            }

        }
        System.out.println(matrix);

    }
    public static void main(String[]args){
        int [][]temp= {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotate(temp);
    }
}
