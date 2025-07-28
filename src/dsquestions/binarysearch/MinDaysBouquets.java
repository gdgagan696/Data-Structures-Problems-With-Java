package dsquestions.binarysearch;

import java.util.Arrays;

public class MinDaysBouquets {
    public static int minDays(int[] bloomDay, int m, int k) {
        int low= Arrays.stream(bloomDay).min().getAsInt();
        int high= Arrays.stream(bloomDay).max().getAsInt();
        int res=-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(canMakeBouquets(bloomDay,k,mid)>=m){
                high=mid-1;
                res=mid;
            }
            else {
                low=mid+1;
            }
        }
        return res;
    }

    private static int canMakeBouquets(int[] bloomDay, int k, int mid) {
        int x=0;
        int total=0;
        for (int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=mid){
                x++;
            }
            else {
                x=0;
            }
            if(x==k){
                total++;
                x=0;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1,10,3,10,2},3,1));
    }
}
