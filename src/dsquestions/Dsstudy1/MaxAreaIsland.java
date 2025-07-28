package dsquestions.Dsstudy1;

import java.util.ArrayList;
import java.util.List;

public class MaxAreaIsland {
    public static int maxAreaOfIsland(int[][] grid) {

        int size=0;
        boolean visited[][]=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    List<Integer> comp=new ArrayList<>();
                    maxAreaOfIslandUtil(grid,i,j,comp,visited);
                    size=Math.max(size,comp.size());
                }
            }
        }
        return size;
    }

    private static void maxAreaOfIslandUtil(int [][]grid,int row,int col,List<Integer>comp,boolean[][]visited){
        if(row>=grid.length || row<0 || col>=grid[0].length || col<0 || visited[row][col] || grid[row][col]==0){
            return;
        }
        comp.add(grid[row][col]);
        visited[row][col]=true;
        maxAreaOfIslandUtil(grid,row+1,col,comp,visited);
        maxAreaOfIslandUtil(grid,row-1,col,comp,visited);
        maxAreaOfIslandUtil(grid,row,col+1,comp,visited);
        maxAreaOfIslandUtil(grid,row,col-1,comp,visited);
    }

    public static void main(String[]args){
        int [][]grid={{1}};
        System.out.println(maxAreaOfIsland(grid));

    }
}
