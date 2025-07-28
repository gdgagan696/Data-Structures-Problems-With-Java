package dsquestions;

public class AddTwoNumbers {
	ListNode root;

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode head1 = l1;
		ListNode head2 = l2;
		ListNode result = null;
		ListNode temp = null;
		ListNode prev = null;
		int carry = 0;
		while (head1 != null || head2 != null) {
			int val1 = head1 == null ? 0 : head1.val;
			int val2 = head2 == null ? 0 : head2.val;
			int sum = val1 + val2 + carry;
			carry = sum > 9 ? 1 : 0;
			temp = new ListNode(sum % 10);
			if (result == null) {
				result = temp;
			} else {
				prev.next = temp;
			}
			prev = temp;
			head1 = head1 != null ? head1.next : head1;
			head2 = head2 != null ? head2.next : head2;
		}
		if (carry > 0) {
			ListNode carryNode = new ListNode(carry);
			temp.next = carryNode;
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
