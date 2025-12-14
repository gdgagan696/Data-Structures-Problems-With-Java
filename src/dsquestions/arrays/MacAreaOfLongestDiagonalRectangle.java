package dsquestions.arrays;

public class MacAreaOfLongestDiagonalRectangle {

    public int areaOfMaxDiagonal(int[][] dimensions) {

        int maxD = -1;
        int ans = 0;
        for (int i = 0; i < dimensions.length; i++) {
            int[] dim = dimensions[i];
            int diag = dim[0] * dim[0] + dim[1] * dim[1];
            int area = dim[0] * dim[1];
            if (maxD < diag) {
                maxD = diag;
                ans = area;
            } else if (maxD == diag) {
                ans = Math.max(ans, area);
            }
        }
        return ans;

    }

}
