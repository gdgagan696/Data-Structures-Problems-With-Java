package dsquestions.arrays;

public class RemoveDuplicatesInPlace {
    public static int removeDuplicates(int[] nums) {
        int i=0;
        int k=0;
        while (i<nums.length){
            nums[k++]=nums[i];
            while (i+1<nums.length && nums[i]==nums[i+1]){
                i++;
            }
            i++;
        }
        return k;
    }

    public static void main(String[] args) {

        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

}
