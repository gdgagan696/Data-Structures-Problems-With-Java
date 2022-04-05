package dsquestions.arrays;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int currArea = 0;
            for (int j = i + 1; j < height.length; j++) {
                int currMin = Math.min(height[j], height[i]);
                currArea = Math.max(currArea, currMin * (j - i));
            }
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    public int maxArea_Optimized(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            int area = h * w;
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }
}
