package dsquestions.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLL {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode current = headA;
        while (current != null) {
            set.add(current);
            current = current.next;
        }
        current = headB;
        while (current != null) {
            if (!set.add(current)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

}
