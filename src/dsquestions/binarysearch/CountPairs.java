package dsquestions.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountPairs {
    public static int countPairs(List<Integer> nums, int target) {
        int res = 0;
        int low = 0, high = nums.size() - 1;
        Collections.sort(nums);
        while (low < high) {
            int sum = nums.get(low) + nums.get(high);
            if (sum < target) {
                res+=high-low;
                low++;
            } else {
                high--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        System.out.println(countPairs(list, 2));
    }
}
