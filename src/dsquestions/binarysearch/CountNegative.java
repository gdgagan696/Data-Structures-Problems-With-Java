package dsquestions.binarysearch;

public class CountNegative {
    public static int countNegatives(int[][] grid) {
        int res = 0;
        for (int[] g : grid) {
            res += binarySearch(g);
        }
        return res;
    }

    private static int binarySearch(int[] grid) {
        int low = 0;
        int high = grid.length - 1;
        int res=0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (grid[mid] < 0) {
                res+=high-mid+1;
                high=mid-1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [][]grid={
                {4,3,2,-1},
                {3,2,1,-1},
                {1,1,-1,-2},
                {-1,-1,-2,-3}
        };
        System.out.println(countNegatives(grid));
    }
}
