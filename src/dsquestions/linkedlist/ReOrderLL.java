package dsquestions.linkedlist;

import java.util.Stack;

public class ReOrderLL {
    public static void reorderList(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        ListNode current=head;
        while (current!=null){
            stack.push(current);
            current=current.next;
        }
        current=head;
        int i=0;
        int size=stack.size();
        while (i<size/2){
            i++;
            ListNode temp=stack.pop();
            ListNode next=current.next;
            current.next=temp;
            temp.next=next;
            current=next;
        }
        current.next=null;
        System.out.println("DONE");
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        reorderList(head);
    }
}
