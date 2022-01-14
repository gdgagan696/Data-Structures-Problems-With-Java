package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>result=new ArrayList<>();
        int minRow=0;
        int maxColumn=matrix[0].length-1;
        int maxRow=matrix.length-1;
        int minColumn=0;
        int total=matrix.length*matrix[0].length;
        int count=0;
        while (count<total){
            for(int j=minColumn,i=minRow;j<=maxColumn && count<total;j++){
                result.add(matrix[i][j]);
                count++;
            }
            minRow++;
            for(int i=minRow,j=maxColumn;i<=maxRow && count<total;i++){
                result.add(matrix[i][j]);
                count++;
            }
            maxColumn--;
            for(int j=maxColumn,i=maxRow;j>=minColumn && count<total;j--){
                result.add(matrix[i][j]);
                count++;
            }
            maxRow--;
            for(int i=maxRow,j=minColumn;i>=minRow && count<total;i--){
                result.add(matrix[i][j]);
                count++;
            }
            minColumn++;
        }
        return result;



    }
    public static void main(String[]args){
        int[][]matrix={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));

    }
}
