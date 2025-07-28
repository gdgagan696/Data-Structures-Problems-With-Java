package dsquestions.Dsstudy1;

import java.util.Arrays;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        floodFillUtil(image, sr, sc, newColor, image[sr][sc]);
        return image;

    }

    private static void floodFillUtil(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        floodFillUtil(image, sr + 1, sc, newColor, oldColor);
        floodFillUtil(image, sr - 1, sc, newColor, oldColor);
        floodFillUtil(image, sr, sc + 1, newColor, oldColor);
        floodFillUtil(image, sr, sc - 1, newColor, oldColor);

    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };
        int[][] res = floodFill(image, 1, 1, 2);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
