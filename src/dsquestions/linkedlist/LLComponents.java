package dsquestions.linkedlist;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LLComponents {

    public static int numComponents(ListNode head, int[] nums) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int res = 0;
        ListNode current = head;
        ListNode prev = head;
        while (current != null && !set.contains(current.val)) {
            current = current.next;
        }
        while (current != null) {
            if (!set.contains(current.val)) {
                res++;
                while (current != null && !set.contains(current.val)) {
                    current = current.next;
                }
                prev = current;
            } else {
                current = current.next;
            }
        }
        return prev == null ? res : res + 1;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(0);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(1);
        System.out.println(numComponents(head, new int[]{4}));

    }

}
