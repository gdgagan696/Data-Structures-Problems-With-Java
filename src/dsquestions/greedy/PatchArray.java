package dsquestions.greedy;

public class PatchArray {
    public static int minPatches(int[] nums, int n) {
        int max=0;
        int i=0;
        int count=0;
        while (max<n){
            if(i<nums.length && nums[i]<=max+1){
                max+=nums[i];
                i++;
            }
            else {
                max+=max+1;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1,3},6));
    }
}
