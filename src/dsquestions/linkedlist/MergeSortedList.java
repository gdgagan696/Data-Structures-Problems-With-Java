package dsquestions.linkedlist;

public class MergeSortedList {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2!=null)return  l2;
        if(l2==null && l1!=null)return  l1;
        ListNode current1=l1;
        ListNode current2=l2;
        ListNode result=new ListNode(0);
        ListNode temp=result;
        while (current1!=null && current2!=null){
            if(current1.val<=current2.val){
                temp.next=current1;
                current1=current1.next;
            }
            else{
                temp.next=current2;
                current2=current2.next;
            }
            temp=temp.next;
        }
        if(current1!=null){
            temp.next=current1;
        }

        else{
            temp.next=current2;
            }
        return result.next;

    }

    public static void main(String[]args){
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        mergeTwoLists(listNode1,listNode2);

    }
}
