package dsquestions.arrays;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        int total=n1+n2;
        int med=-1;
        int medianElement=-1;
        if(total%2!=0){
            med=(total+1)/2-1;
        }
        else{
            med=(total+1)/2-1;
        }
        int i=0;
        int j=0;
        if(total%2!=0) {
            while (i < nums1.length || j < nums2.length) {
                if (i == med) {
                    medianElement = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
                    break;
                } else if (j == med) {
                    medianElement = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
                    break;
                } else if (nums1[i] < nums2[j]) i++;
                else j++;
            }
            return (double) medianElement;
        }
        else
        {
            int temp1=-1;
            int temp2=-1;
            while (i < nums1.length || j < nums2.length) {
                if (i == med) {
                     temp1= nums1[i] < nums2[j] ? nums1[i] : nums2[j];
                    if(i+1<nums1.length){
                        temp2=nums1[i+1] < nums2[j] ? nums1[i+1] : nums2[j];
                    }
                    else{
                        temp2=nums2[j];
                    }
                    break;
                } else if (j == med) {
                    temp1 = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
                    if(j+1<nums2.length){
                        temp2=nums2[j+1] < nums2[i] ? nums2[j+1] : nums1[i];
                    }
                    else{
                        temp2=nums2[i];
                    }
                    break;
                } else if (nums1[i] < nums2[j]) i++;
                else j++;
            }
            return (double) (temp1+temp2)/2;
        }

    }
    public static void main(String[]args){
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{2},new int[]{1,3}));
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{},new int[]{1}));


    }
}
