package dsquestions;

import dsquestions.linkedlist.ListNode;

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    ListNode head;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        head = new ListNode(-1);
        ListNode temp = head;

        while (iterator.hasNext()) {
            temp.next = new ListNode(iterator.next());
            temp = temp.next;
        }
        head = head.next;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return head.val;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int val = head.val;
        head = head.next;
        return val;
    }

    @Override
    public boolean hasNext() {
        return head != null;
    }
}
