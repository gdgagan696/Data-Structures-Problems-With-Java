package dsquestions;

public class IntersectionOfLL {

	ListNode head;

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthOfFirstLL = lengthOfLL(headA);
		int lengthOfSecondLL = lengthOfLL(headB);
		if (lengthOfFirstLL == lengthOfSecondLL && headA != null && headB != null && headA.equals(headB)) {
			return headA;
		}

		if (lengthOfFirstLL > lengthOfSecondLL) {
			return findIntersection(headA, headB, lengthOfFirstLL - lengthOfSecondLL);
		} else {
			return findIntersection(headB, headA, lengthOfSecondLL - lengthOfFirstLL);
		}

	}

	private static ListNode findIntersection(ListNode headA, ListNode headB, int difference) {
		ListNode currentA = headA;
		ListNode currentB = headB;

		while (difference-- > 0) {
			if (currentA == null) {
				return null;
			}
			currentA = currentA.next;
		}

		while (currentA != null && currentB != null) {
			if (currentA.equals(currentB)) {
				return currentA;
			}
			currentA = currentA.next;
			currentB = currentB.next;
		}
		return null;

	}

	private static int lengthOfLL(ListNode head) {
		int length = 0;
		ListNode current = head;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	public static void main(String[] args) {
		System.err.println(getIntersectionNode(null, null));

	}

}
