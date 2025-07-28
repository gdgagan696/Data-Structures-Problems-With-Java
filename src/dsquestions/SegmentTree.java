package dsquestions;

import java.util.LinkedList;

public class SegmentTree {
	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;
	}

	private Node root;

	SegmentTree(int[] arr) {
		this.root = this.constructTree(arr, 0, arr.length - 1);
	}

	private Node constructTree(int[] arr, int si, int ei) {
		if (si == ei) {
			Node node = new Node();
			node.data = arr[si];
			node.si = si;
			node.ei = si;
			node.left = null;
			node.right = null;
			return node;
		}
		Node node = new Node();
		node.si = si;
		node.ei = ei;
		int mid = (si + ei) / 2;
		node.left = constructTree(arr, si, mid);
		node.right = this.constructTree(arr, mid + 1, ei);
		node.data = node.left.data + node.right.data;// depends on the operation
		return node;
	}

	public void display() {
		LinkedList<Node> pqueue = new LinkedList<>();
		LinkedList<Node> squeue = new LinkedList<>();
		pqueue.addLast(this.root);
		while (!pqueue.isEmpty()) {
			Node rv = pqueue.remove();
			System.out.print("Data=" + rv.data + " and interval =[" + rv.si + "-" + rv.ei + "]   ");
			if (rv.left != null) {
				squeue.add(rv.left);
			}
			if (rv.right != null) {
				squeue.add(rv.right);
			}
			if (pqueue.isEmpty()) {
				pqueue = squeue;
				squeue = new LinkedList<>();
				System.out.println();
			}
		}
	}

	public int query(int qsi, int qei) {
		return this.query(this.root, qsi, qei);
	}

	private int query(Node node, int qsi, int qei) {
		if (node.si >= qsi && node.ei <= qei) {
			// node interval completely inside query interval
			return node.data;
		} else if (node.ei < qsi || node.si > qei) {
			// completely outside
			return 0;// depends on operation

		} else {
			// overlapping
			int left = this.query(node.left, qsi, qei);
			int right = this.query(node.right, qsi, qei);
			return left + right;
		}
	}

	public void update(int index, int value) {
		this.root.data = this.update(this.root, index, value);
	}

	private int update(Node node, int index, int value) {
		if (index >= node.si && index <= node.ei) {
			if (index == node.si && index == node.ei) {
				node.data = value;
			} else {
				int left = this.update(node.left, index, value);
				int right = this.update(node.right, index, value);
				node.data = left + right;

			}
		}

		return node.data;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 8, 7, 6, -2, -8, 4, 9 };
		SegmentTree tree = new SegmentTree(arr);
		tree.display();
		System.out.printf("Sum of range %d and  %d is: %d", 2, 6, tree.query(2, 6));
		System.out.println();
		System.out.println("**********************************");
		tree.update(2, 9);
		tree.display();
		System.out.printf("Sum of range %d and  %d is: %d", 2, 6, tree.query(2, 6));
	}
}
