package dsquestions.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt((ListNode n) -> n.val));
        ListNode resultHead = new ListNode();
        ListNode temp = resultHead;

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        while (pq.size() > 0) {
            ListNode node = pq.poll();
            temp.next = node;
            temp = temp.next;
            if (node.next != null) {
                pq.add(node.next);
            }

        }
        return resultHead.next;
    }
}
