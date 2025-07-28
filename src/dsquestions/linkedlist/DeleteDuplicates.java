package dsquestions.linkedlist;

public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else
                current = current.next;
        }
        return head;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(2);
        deleteDuplicates(listNode);

    }
}
