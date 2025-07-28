package dsquestions.linkedlist;

public class InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {

        if(head==null || head.next==null)return head;

        ListNode current=head;
        ListNode result=null;
        while (current!=null){
            ListNode next=current.next;
            result=insert(current,result);
            current=next;
        }
        return result;

    }

    private static ListNode insert(ListNode newNode, ListNode result) {
        if(result==null || result.val>newNode.val){
            newNode.next=result;
            result=newNode;
        }
        else {
            ListNode temp = result;
            while (temp.next != null && temp.next.val < newNode.val) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return result;
    }

    public static void main(String[]args){
        ListNode listNode = new ListNode(0);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(5);
        insertionSortList(listNode);

    }
}
