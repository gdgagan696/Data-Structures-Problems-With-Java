package dsquestions.linkedlist;

public class MergeNodesBetweenZeroes {
    public static ListNode mergeNodes(ListNode head) {
        ListNode temp = new ListNode(-1);
        ListNode newHead = temp;
        ListNode current = head.next;
        ListNode node = new ListNode(0);
        while (current != null) {
            if (current.val == 0) {
                temp.next = new ListNode(node.val);
                temp = temp.next;
                node.val = 0;
            } else {
                node.val += current.val;
            }
            current = current.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);
        System.out.println(mergeNodes(head));
    }
}
