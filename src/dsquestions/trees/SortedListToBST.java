package dsquestions.trees;

import dsquestions.linkedlist.ListNode;
import java.util.ArrayList;
import java.util.List;

public class SortedListToBST {

    public static TreeNode sortedListToBST(ListNode head) {

        ListNode current = head;
        List<Integer> list = new ArrayList<>();
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        int[] nums = list.stream().mapToInt(x -> x.intValue()).toArray();
        return sortedArrayToBST(nums);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        return constructTree(nums, 0, nums.length - 1);
    }

    private static TreeNode constructTree(int[] nums, int start, int end) {

        if (start == end) {
            return new TreeNode(nums[start]);
        }
        if (start > end) {
            return null;
        }

        final int mid = (end + start) >> 1;
        final TreeNode left = constructTree(nums, start, mid - 1);
        final TreeNode right = constructTree(nums, mid + 1, end);
        return new TreeNode(nums[mid], left, right);
    }

}
