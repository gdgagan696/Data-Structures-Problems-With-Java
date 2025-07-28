package dsquestions.linkedlist;

import java.util.Stack;

public class RemoveNodesFromLL {
    public static ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            while (!stack.isEmpty() && stack.peek().val < current.val) {
                stack.pop();
            }
            stack.push(current);
            current = current.next;
        }
        head=stack.pop();
        current=head;
        while (!stack.isEmpty()) {
            ListNode temp=stack.pop();
            temp.next=null;
            current.next = temp;
            current=current.next;
        }
        return reverse(head);
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
        ListNode node=new ListNode(1);
        node.next=new ListNode(1);
        node.next.next=new ListNode(1);
        node.next.next.next=new ListNode(1);
//        node.next.next.next.next=new ListNode(8);
        removeNodes(node);
    }
}
