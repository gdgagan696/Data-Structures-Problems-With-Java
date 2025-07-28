package dsquestions.linkedlist;

import java.util.*;

public class NextGreaterLL {

    public static int[] nextLargerNodes(ListNode head) {
        head=reverse(head);
        Stack<Integer>stack=new Stack<>();
        List<Integer>result=new ArrayList<>();
        result.add(0);
        stack.push(head.val);
        ListNode current=head.next;
        while (current!=null){
            int val=current.val;
            current=current.next;
            while (stack.size()>0 && val>stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                result.add(0);
            }
            else{
                result.add(stack.peek());
            }
            stack.add(val);
        }
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();

    }

    private static ListNode reverse(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode current=head;
        ListNode next=current.next;
        ListNode result=reverse(next);
        next.next=current;
        current.next=null;
        return result;

    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(7);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(5);
        System.out.println(Arrays.toString(nextLargerNodes(listNode)));


    }
}
