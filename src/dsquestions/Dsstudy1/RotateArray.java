package dsquestions.Dsstudy1;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length);
       reverse(nums,0,nums.length);
    }

    public void reverse(int []nums,int i,int j){
        while (i<j){
            int x=nums[i];
            nums[i]=nums[j];
            nums[j]=x;
            i++;
            j--;
        }
    }

}
