package dsquestions.arrays;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int n=nums.length;
        int expectedSum=n*(n+1)/2;
        int actualSum=0;
        for(int x:nums){
            actualSum+=x;
        }
        return expectedSum-actualSum;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1,2,4}));
    }

}
