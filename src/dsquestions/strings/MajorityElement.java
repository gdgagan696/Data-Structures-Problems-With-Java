package dsquestions.strings;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 1;
        int candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else {
                if (candidate == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int num : nums) {
            if (candidate == num) {
                count++;
            }
        }
        if (count >= nums.length / 2) {
            return candidate;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }
}
