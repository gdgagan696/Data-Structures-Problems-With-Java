package dsquestions;

import java.util.ArrayList;
import java.util.List;

public class SwapNodes {
    ListNode head;
    class  ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }

    }
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer>listValues=new ArrayList<>();
        ListNode current=head;
        while (current!=null){
            listValues.add(current.val);
            current=current.next;
        }
        int valAtKFromBeginning=listValues.get(k-1);
        int valAtKFromEnd=listValues.get(listValues.size()-k);
        listValues.set(k-1,valAtKFromEnd);
        listValues.set(listValues.size()-k,valAtKFromBeginning);
        return reBuildList(null,listValues);
    }

    private ListNode reBuildList(ListNode head,List<Integer>listValues) {
        ListNode prev=null;
        ListNode temp=null;
        for(int val:listValues){
            temp=new ListNode(val);
            if(head==null){
                head=temp;
                prev=head;
            }
            else{
                prev.next=temp;
                prev=temp;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        SwapNodes swapNodes = new SwapNodes();
        swapNodes.head = new SwapNodes().new ListNode(1);
        swapNodes.head.next = new SwapNodes().new ListNode(2);
        swapNodes.head.next.next = new SwapNodes().new ListNode(3);
        swapNodes.head.next.next.next = new SwapNodes().new ListNode(4);
        swapNodes.head.next.next.next.next = new SwapNodes().new ListNode(5);
        swapNodes.swapNodes(swapNodes.head,2);


    }
}
