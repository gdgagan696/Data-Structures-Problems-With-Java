package dsquestions.Dsstudy1;

import dsquestions.linkedlist.ListNode;

public class MiddleOfLL {

    public ListNode middleNode(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;

    }
}
