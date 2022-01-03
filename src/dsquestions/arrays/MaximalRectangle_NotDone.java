package dsquestions.arrays;

import java.util.Stack;

public class MaximalRectangle_NotDone {
    public int maximalRectangle(char[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int heights[] = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j] += 1;
                }
            }
        }

        return largestAreaInHistogram(heights);

    }

    private int largestAreaInHistogram(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int left[] = new int[heights.length];
        int right[] = new int[heights.length];
        int maxArea = -1;
        left[0] = -1;
        right[heights.length - 1] = heights.length;
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            while (stack.size() > 0 && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        stack.push(heights.length-1);
        for (int i = heights.length - 2; i >= 0; i--) {
            while (stack.size() > 0 && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = heights.length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            int area = (right[i] - left[i]-1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
