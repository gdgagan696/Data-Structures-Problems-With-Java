package dsquestions.linkedlist;

public class MergeInBetween {
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode current=list1;
        ListNode prev=null;
        int count=0;
        while (current!=null && count++<a){
            prev=current;
            current=current.next;
        }
        while (current!=null && count++<=b){
            current=current.next;
        }
        prev.next=list2;
        ListNode tail=list2;
        while (tail.next!=null){
            tail=tail.next;
        }
        tail.next=current.next;
        return  list1;
    }
    public static void main(String[]args){
        ListNode listNode1 = new ListNode(0);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(2);
        listNode1.next.next.next = new ListNode(1);
        listNode1.next.next.next.next = new ListNode(4);
        listNode1.next.next.next.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(20);
        listNode2.next = new ListNode(25);
        listNode2.next.next = new ListNode(26);

        mergeInBetween(listNode1,3,4,listNode2);

    }
}
