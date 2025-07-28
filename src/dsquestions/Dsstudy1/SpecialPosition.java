package dsquestions.Dsstudy1;

public class SpecialPosition {
    public int numSpecial(int[][] mat) {
        int total=0;
        for(int i=0;i<mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1 && rowsAndColZeros(mat,i,j)){
                    total++;
                }
            }
        }
        return total;

    }

    private boolean rowsAndColZeros(int[][] mat, int i, int j) {
        for(int k=0;k<mat[0].length;k++){
            if(k!=j && mat[i][k]==1){
                return false;
            }
        }
        for(int k=0;k<mat.length;k++){
            if(k!=i && mat[k][j]==1){
                return false;
            }
        }
        return true;
    }
}
