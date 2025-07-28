package dsquestions.linkedlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyWithRandomPointer {

    public static ListNode copyRandomList(ListNode head) {

        Map<ListNode, ListNode> hm = new HashMap<>();
        ListNode current = head;
        ListNode newHead = null;
        ListNode temp = null;
        while (current != null) {
            ListNode newNode = new ListNode(current.val);
            hm.put(current, newNode);
            current = current.next;
            if (newHead == null) {
                newHead = newNode;
                temp = newHead;
                continue;
            }
            temp.next = newNode;
            temp = temp.next;

        }
        current = head;
        while (current != null) {
            ListNode copyNode = hm.get(current);
            copyNode.random = current.random == null ? null : hm.get(current.random);
            current = current.next;
        }
        return newHead;
    }

    public static ListNode copyRandomList_ConstantSpace(ListNode head) {
        if (head == null) return head;
        ListNode current = head;
        ListNode newHead = null;
        //Clonning Linked List
        while (current != null) {
            ListNode newNode = new ListNode(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = current.next.next;
        }
        current = head;
        newHead = head.next;
        while (current != null) {
            current.next.random = current.random != null ? current.random.next : null;
            current = current.next.next;
        }
        current = head;
        ListNode temp = newHead;
        while (current != null && temp != null) {
            current.next = current.next != null ? current.next.next : current.next;
            temp.next = temp.next != null ? temp.next.next : temp.next;
            current = current.next;
            temp = temp.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(7);
        listNode.next = new ListNode(13);
        listNode.next.next = new ListNode(11);
        listNode.next.next.next = new ListNode(10);
        listNode.next.next.next.next = new ListNode(1);

        listNode.random = null;
        listNode.next.random = listNode;
        listNode.next.next.random = listNode.next.next.next.next;
        listNode.next.next.next.random = listNode.next.next;
        listNode.next.next.next.next.random = listNode;
//        copyRandomList(listNode);
        copyRandomList_ConstantSpace(listNode);
    }
}
