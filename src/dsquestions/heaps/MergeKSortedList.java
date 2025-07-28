package dsquestions.heaps;

import dsquestions.linkedlist.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        for(ListNode node:lists){
            if(node!=null) pq.add(node);
        }
        while (pq.size()>0){
            ListNode temp=pq.poll();
            tail.next=temp;
            tail=tail.next;
            if(tail.next!=null){
                pq.add(tail.next);
            }
        }
        return dummy.next;

    }
}
