package dsquestions.linkedlist;

public class SwapNodes {
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode current = head;
        ListNode kthNode = null;
        int total = 0;
        while (current != null) {
            if (k == total + 1) {
                kthNode = current;
            }
            current = current.next;
            total++;
        }
        int kthEndNode = total - k + 1;
        current = head;
        while (--kthEndNode > 0) {
            current = current.next;
        }
        int v1 = current.val;
        int v2 = kthNode.val;
        kthNode.val = v1;
        current.val = v2;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        swapNodes(listNode, 2);

    }
}
