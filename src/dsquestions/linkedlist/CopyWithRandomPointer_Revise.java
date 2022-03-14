package dsquestions.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyWithRandomPointer_Revise {
    public ListNode copyRandomList(ListNode head) {
        if(head==null){
            return head;
        }
        Map<ListNode,ListNode> hm=new HashMap<>();
        ListNode result=new ListNode(-1);
        ListNode temp=result;
        ListNode current=head;
        while (current!=null){
            ListNode newNode=new ListNode(current.val);
            temp.next=newNode;
            temp=temp.next;
            hm.put(current,newNode);
            current=current.next;
        }
        current=head;
        while (current!=null){
            ListNode currentDeep=hm.get(current);
            ListNode currentRandom=current.random;
            if(currentRandom!=null) {
                ListNode randomDeep = hm.get(currentRandom);
                currentDeep.random=randomDeep;
            }
            current=current.next;
        }
        return result.next;
    }


    public ListNode copyRandomList_Optimised(ListNode head) {

        if(head==null){
            return head;
        }

        ListNode current=head;
        while (current!=null){
            ListNode next=current.next;
            ListNode deepCurrent=new ListNode(current.val);
            current.next=deepCurrent;
            deepCurrent.next=next;
            current=next;
        }
        current=head;
        while (current!=null){
            current.next.random=current.random!=null?current.random.next:null;
            current=current.next.next;
        }
        ListNode result=new ListNode(-1);
        ListNode temp=result;
        current=head;
        while (current!=null){
            temp.next=current.next;
            current.next=current.next.next;
            temp=temp.next;
            current=current.next;
        }
        return current.next;

    }
}
