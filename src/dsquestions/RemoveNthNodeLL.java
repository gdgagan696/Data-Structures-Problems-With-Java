package dsquestions;

public class RemoveNthNodeLL {
	ListNode root;

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	private static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode prev = null;
		ListNode current = head;
		int len = 0;
		while (current != null) {
			len++;
			current = current.next;
		}

		int numFromBeginning = len - n + 1;
		if (numFromBeginning == 1) {
			head = head.next;
		} else {
			current = head;
			while (--numFromBeginning > 0) {
				prev = current;
				current = current.next;
			}
			prev.next = current.next;
		}
		return head;

	}

	public static void main(String[] args) {
		removeNthFromEnd(null, 1);

	}

}
