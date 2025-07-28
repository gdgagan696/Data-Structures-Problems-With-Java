package dsquestions.binarysearch;

import java.util.Arrays;

public class FindDistanceValue {
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);;
        int count=0;
        for (int x:arr1){
            if(isValid(arr2,x,d)){
                count++;
            }
        }
        return count;

    }

    private static boolean isValid(int[] arr2, int x, int d) {
        int low=0;
        int high=arr2.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(Math.abs(x-arr2[mid])<=d){
                return false;
            }
            else if(arr2[mid]>x){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int []arr1 = {-3,10,2,8,0,10};
        int []arr2 = {-9,-1,-4,-9,-8};
        System.out.println(findTheDistanceValue(arr1,arr2,9));

    }
}
