package dsquestions.linkedlist;

public class RemoveNthNodeFromLL {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode current = head;
        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }

        if (current == null) {
            return head.next;
        }
        while (current.next != null) {
            current = current.next;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;


    }
}
