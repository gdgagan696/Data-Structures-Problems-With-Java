package dsquestions.practice;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int k=m+n-1;
        int i=m-1;
        int j=n-1;
        while (k>=0 && j>=0 && i>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i--];
            }
            else {
                nums1[k]=nums2[j--];
            }
            k--;
        }
    }

    public static void main(String[] args) {
        merge(new int[]{1}, 1,new int[]{},0);
    }

}
