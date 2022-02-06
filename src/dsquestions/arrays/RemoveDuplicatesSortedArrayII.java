package dsquestions.arrays;

public class RemoveDuplicatesSortedArrayII {
    public static int removeDuplicates(int[] nums) {

        int i = 0, j = 0;
        while (i < nums.length) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                int count = 0;
                int num = nums[i];
                while (i < nums.length && num == nums[i]) {
                    count++;
                    i++;
                }
                int temp = 2;
                while (count > 0 && temp > 0) {
                    nums[j++] = num;
                    count--;
                    temp--;
                }
            } else {
                nums[j++] = nums[i++];
            }
        }
        return j;

    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

}
