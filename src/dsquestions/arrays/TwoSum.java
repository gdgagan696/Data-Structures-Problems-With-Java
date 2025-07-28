package dsquestions.arrays;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        int ans[]=new int[2];
        int firstIndex=0;
        int secondIndex=numbers.length-1;
        while (firstIndex<secondIndex){
            int sum=numbers[firstIndex]+numbers[secondIndex];
            if(sum==target){
                ans[0]=firstIndex+1;
                ans[1]=secondIndex+1;
                return ans;
            }
            else if(sum>target){
                secondIndex--;
            }
            else if(sum<target){
                firstIndex++;
            }
        }
    return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{-1,0},-1)));

    }
}
