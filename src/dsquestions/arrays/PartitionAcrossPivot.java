package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionAcrossPivot {

    public static int[] pivotArray(int[] nums, int pivot) {

        List<Integer> less=new ArrayList<>();
        List<Integer> equal=new ArrayList<>();
        List<Integer> more=new ArrayList<>();
        for (int x:nums) {
            if(x<pivot){
                less.add(x);
            }
            else if(x==pivot){
                equal.add(x);
            }
            else {
                more.add(x);
            }
        }

        less.addAll(equal);
        less.addAll(more);
        return less.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {

        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        System.out.println(Arrays.toString(pivotArray(nums, 10)));

    }

}
