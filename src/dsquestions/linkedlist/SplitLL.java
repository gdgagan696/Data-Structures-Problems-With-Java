package dsquestions.linkedlist;

public class SplitLL {

    public static ListNode[] splitListToParts(ListNode head, int k) {

        int size = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            size++;
        }
        int eachPart = size / k;
        int extra = size % k;
        current = head;
        ListNode[] res = new ListNode[k];
        int index = 0;
        while (current != null) {
            int partSize = eachPart;
            if (extra > 0) {
                partSize++;
                extra--;
            }
            ListNode newHead = current;
            ListNode temp = current;

            for (int i = 1; i < partSize && temp != null; i++) {
                temp = temp.next;
            }

            // detach the current part
            if (temp != null) {
                ListNode nextPart = temp.next;
                temp.next = null;
                current = nextPart;
            } else {
                current = null;
            }
            res[index++] = newHead;
        }
        return res;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        splitListToParts(head, 3);

    }

}
