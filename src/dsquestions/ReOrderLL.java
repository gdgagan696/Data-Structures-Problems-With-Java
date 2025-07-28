package dsquestions;

public class ReOrderLL {

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

	private static void reorderList(ListNode head) {

		if (head == null || head.next == null) {
			return;
		}
		ListNode prev = head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;

		ListNode node1 = head;
		ListNode node2 = reverseLL(slow);
		mergeLL(node1, node2);

	}

	private static ListNode reverseLL(ListNode node) {
		if (node == null)
			return null;
		ListNode prev = null;
		ListNode current = node;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private static void mergeLL(ListNode node1, ListNode node2) {
		while (node2 != null) {
			ListNode next = node1.next;
			node1.next = node2;
			node1 = node2;
			node2 = next;
		}
	}

	private static void printlist(ListNode node) {
		if (node == null) {
			return;
		}
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
	}

	public static void main(String[] args) {

		ReOrderLL reOrderLL = new ReOrderLL();
		reOrderLL.head = new ListNode(1);
		reOrderLL.head.next = new ListNode(2);
		reOrderLL.head.next.next = new ListNode(3);
		reOrderLL.head.next.next.next = new ListNode(4);
		reOrderLL.head.next.next.next.next = new ListNode(5);
		printlist(reOrderLL.head);
		reorderList(reOrderLL.head);
		System.out.println();
		printlist(reOrderLL.head);

	}

}
