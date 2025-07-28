package dsquestions.linkedlist;

public class RotateLL {
    /*
    1-2-3-4-5 (2)
    4-5-1-2-3
     */

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int total = 0;
        ListNode current = head;
        ListNode last = null;
        while (current != null) {
            total++;
            last = current;
            current = current.next;
        }
        k = k % total;
        if (k == 0) return head;
        ListNode kthNode = null;
        ListNode k_1Node = null;
        int kth = total - k;
        for (current = head; kth > 0; current = current.next) {
            kth--;
            k_1Node = current;
        }
        kthNode = current;
        last.next = head;
        k_1Node.next = null;
        head = kthNode;
        return head;


    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        rotateRight(listNode, 4);


    }
}
