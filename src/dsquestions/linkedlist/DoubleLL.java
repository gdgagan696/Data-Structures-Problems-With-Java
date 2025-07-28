package dsquestions.linkedlist;

public class DoubleLL {
    public static ListNode doubleIt(ListNode head) {
        head=reverse(head);
        ListNode current=head;
        int carry=0;
        while (current!=null){
            int val=2*current.val+carry;
            carry=val/10;
            current.val=val%10;
            current=current.next;
        }
        head=reverse(head);
        if(carry>0){
            ListNode carryNode=new ListNode(carry);
            carryNode.next=head;
            return carryNode;
        }
        return head;

    }

    private static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(8);
        head.next.next=new ListNode(9);
        doubleIt(head);
    }
}
