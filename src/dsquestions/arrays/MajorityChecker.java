package dsquestions.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityChecker {
    int arr[];

    public MajorityChecker(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int threshold) {
        int majIndex=-1;
        int count=0;
        for (int i = left; i <=right; i++) {
            if(count==0){
                majIndex=i;
                count++;
            }
            else if(arr[majIndex]==arr[i]){
                count++;
            }
            else
            {
                count--;
            }
        }
        count=0;
        for(int i=left;i<=right;i++){
            if(arr[i]==arr[majIndex]){
                count++;
            }
        }
        if(count>=threshold){
            return arr[majIndex];
        }
        return -1;

    }


    public static void main(String[] args) {
        MajorityChecker majorityChecker = new MajorityChecker(new int[]{1, 1, 2, 2, 1, 1});
        System.out.println(majorityChecker.query(0, 3, 3));

    }
}
