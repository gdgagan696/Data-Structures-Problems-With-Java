package dsquestions.arrays;

import java.util.Arrays;

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int []actual=heights.clone();
        Arrays.sort(actual);
        int count=0;
        for (int i=0;i<actual.length;i++){
            if(actual[i]!=heights[i]){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1,1,4,2,1,3}));
    }
}
