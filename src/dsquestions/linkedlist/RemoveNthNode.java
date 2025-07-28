package dsquestions.linkedlist;

public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = slow.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd(head, 1);
    }
}
