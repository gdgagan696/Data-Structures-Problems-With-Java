package dsquestions.practice;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int element = findCandidate(nums);
        int count = 0;
        for (int x : nums) {
            if (element == x) {
                count++;
            }
        }
        return count >= nums.length / 2 ? element : -1;
    }

    private static int findCandidate(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                count = 1;
                candidate = nums[i];
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }


}
