package dsquestions.Dsstudy1;

import dsquestions.linkedlist.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {

        ListNode odd = new ListNode(-1);
        ListNode oddHead = odd;
        ListNode even = new ListNode(-1);
        ListNode evenHead = even;
        int index = 0;
        ListNode current = head;
        while (current != null) {
            index++;
            if (index % 2 == 0) {
                even.next = new ListNode(current.val);
                even = even.next;
            } else {
                odd.next = new ListNode(current.val);
                odd = odd.next;
            }
            current = current.next;
        }

        odd.next = evenHead.next;
        return oddHead.next;

    }
}
