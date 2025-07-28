package dsquestions.linkedlist;

public class OddEvenList {

    public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode odd=null;
        ListNode even=null;
        ListNode oddHead=null;
        ListNode evenHead=null;

        ListNode current=head;
        int i=1;
        while (current!=null){
            if((i&1)>0){
                if(odd==null){
                    odd=new ListNode(current.val);
                    oddHead=odd;
                }
                else{
                    odd.next=new ListNode(current.val);
                    odd=odd.next;
                }
            }
            else{
                if(even==null){
                    even=new ListNode(current.val);
                    evenHead=even;
                }
                else{
                    even.next=new ListNode(current.val);
                    even=even.next;
                }
            }
            i++;
            current=current.next;
        }
        odd.next=evenHead;
        even.next=null;
        return oddHead;
    }
    public static void main(String[]args){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        oddEvenList(listNode);

    }
}
