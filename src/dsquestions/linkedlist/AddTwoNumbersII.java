package dsquestions.linkedlist;

public class AddTwoNumbersII {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode current1 = l1;
        ListNode current2 = l2;
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while (current1 != null && current2 != null) {
            int sum = current1.val + current2.val + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum % 10 : sum;
            temp.next = new ListNode(sum);
            temp = temp.next;
            current1 = current1.next;
            current2 = current2.next;
        }
        while (current1 != null) {
            int sum = current1.val + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum % 10 : sum;
            temp.next = new ListNode(sum);
            temp = temp.next;
            current1 = current1.next;
        }
        while (current2 != null) {
            int sum = current2.val + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum % 10 : sum;
            temp.next = new ListNode(sum);
            temp = temp.next;
            current2 = current2.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return reverse(head.next);

    }


    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);

        int totalSum = 0, carry = 0;
        ListNode ans = new ListNode();
        while (r1 != null || r2 != null) {
            if (r1 != null) {
                totalSum += r1.val;
                r1 = r1.next;
            }
            if (r2 != null) {
                totalSum += r2.val;
                r2 = r2.next;
            }

            ans.val = totalSum % 10;
            carry = totalSum / 10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;
        }

        return carry == 0 ? ans.next: ans;
    }
    private static ListNode reverse(ListNode node) {

        ListNode current = node;
        ListNode prev = null;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }


    public static void main(String[] args) {

        ListNode head1 = new ListNode(7);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(3);

        ListNode head2 = new ListNode(6);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(4);

        addTwoNumbers2(head1, head2);

    }
}
