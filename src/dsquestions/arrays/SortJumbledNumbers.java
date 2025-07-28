package dsquestions.arrays;

import java.util.*;

public class SortJumbledNumbers {
    public static int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < mapping.length; i++) {
            hm.put(i, mapping[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            String num = String.valueOf(nums[i]);
            StringBuilder mappedNum = new StringBuilder();
            for (char ch : num.toCharArray()) {
                mappedNum.append(hm.get(Integer.parseInt(ch + "")));
            }
            int x = Integer.parseInt(mappedNum.toString());
            list.add(new Integer[]{x, i});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        int[] res = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            res[i] = nums[list.get(i)[1]];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};
        System.out.println(Arrays.toString(sortJumbled(mapping, nums)));
    }
}
