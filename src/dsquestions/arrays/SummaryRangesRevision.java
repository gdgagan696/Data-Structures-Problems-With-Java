package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRangesRevision {

    public static List<String> summaryRanges(int[] nums) {
        if(nums.length==0){
            return List.of();
        }
        List<String> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x != nums[i - 1] + 1) {
                StringBuilder sb = new StringBuilder();
                if (temp.size() == 1) {
                    sb.append(temp.get(0));
                    res.add(sb.toString());
                } else {
                    sb.append(temp.get(0)).append("->").append(temp.get(temp.size() - 1));
                    res.add(sb.toString());
                }
                temp.clear();
            }
            temp.add(x);
        }
        StringBuilder sb = new StringBuilder();
        if (temp.size() == 1) {
            sb.append(temp.get(0));
            res.add(sb.toString());
        } else {
            sb.append(temp.get(0)).append("->").append(temp.get(temp.size() - 1));
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {0, 2, 3, 4, 6, 8};
        System.out.println(summaryRanges(nums));
    }

}
