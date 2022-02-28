package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }
        int i = 0;
        int n = nums.length;
        while (i < n) {
            String range = String.valueOf(nums[i]);
            String rangeEnd = "";
            while (i + 1 < n && nums[i + 1] - nums[i] == 1) {
                rangeEnd = String.valueOf(nums[++i]);
            }
            if (rangeEnd.length() > 0) {
                range = range + "->" + rangeEnd;
            }
            result.add(range);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
