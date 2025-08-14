package dsquestions.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class PartitionList {

    public static ListNode partition(ListNode head, int x) {

        List<Integer> less = new ArrayList<>();
        List<Integer> more = new ArrayList<>();

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                less.add(current.val);
            } else {
                more.add(current.val);
            }
            current = current.next;
        }
        less.addAll(more);

        ListNode newHead = null;
        ListNode temp = null;
        for (int num : less) {
            if (newHead == null) {
                newHead = new ListNode(num);
                temp = newHead;
            } else {
                temp.next = new ListNode(num);
                temp = temp.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        partition(head, 3);
    }

}
