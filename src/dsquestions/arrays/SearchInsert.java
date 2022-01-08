package dsquestions.arrays;

public class SearchInsert {
    public static  int searchInsert(int[] nums, int target) {
        if(target==0){
            return 0;
        }
        if(target>nums[nums.length-1]){
            return  nums.length;
        }
        int l = 0;
        int h = nums.length;
        int mid=-1;
        while (l<=h) {
            mid= l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return nums[mid]<target?mid+1:mid;

    }
    public static void main(String[] args) {

        System.out.println(searchInsert(new int[]{1,3,5,6},7));

    }

}
