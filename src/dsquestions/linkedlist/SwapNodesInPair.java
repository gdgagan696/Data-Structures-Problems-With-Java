package dsquestions.linkedlist;

public class SwapNodesInPair {

    public ListNode swapPairs_ValuesSwap(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            int v1 = current.val;
            int v2 = next.val;
            next.val = v1;
            current.val = v2;
            current = current.next.next;
        }
        return head;

    }

    public ListNode swapPairs_PointersSwap(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode prev = null;
        while (slow != null && slow.next != null) {
            ListNode fast = slow.next;
            slow.next = fast.next;
            fast.next = slow;
            if (prev == null) {
                head = fast;
            } else {
                prev.next = fast;
            }

            prev = slow;
            slow = slow.next;
        }

        return head;
    }
}
