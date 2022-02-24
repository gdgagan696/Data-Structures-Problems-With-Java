package dsquestions.linkedlist;

public class SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = findMidPrev(head);
        ListNode mid=prev.next;
        prev.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeList(left, right);

    }

    private static ListNode mergeList(ListNode left, ListNode right) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = new ListNode(left.val);
                left = left.next;
            } else {
                temp.next = new ListNode(right.val);
                right = right.next;
            }
            temp = temp.next;
        }
        while (left != null) {
            temp.next = new ListNode(left.val);
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = new ListNode(right.val);
            right = right.next;
            temp = temp.next;
        }
        return newHead.next;
    }

    private static ListNode findMidPrev(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev=null;
        while (fast != null && fast.next != null) {
            prev=slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        System.out.println(sortList(root));
    }
}
