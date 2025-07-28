package dsquestions.arrays;

import java.util.Arrays;

public class SpiralMatrixIII {
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int row=rStart;
        int col=cStart;
        int [][]res=new int[rows*cols][2];
        int steps=1;
        int index=0;
        int dir=0;
        while (index<rows*cols){
            for(int j=0;j<2;j++){
                for (int i=0;i<steps;i++){
                    if(row>=0 && row<rows && col>=0 && col<cols){
                        res[index++]=new int[]{row,col};
                    }
                    row+=dirs[dir][0];
                    col+=dirs[dir][1];
                }
                dir=(dir+1)%4;
            }
            steps++;
        }
        return res;
    }

    public static void main(String[] args) {
        int rows = 1, cols = 4, rStart = 0, cStart = 0;
        spiralMatrixIII(rows,cols,rStart,cStart);
    }
}
