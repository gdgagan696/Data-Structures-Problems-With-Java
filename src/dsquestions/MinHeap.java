package dsquestions;

import java.util.Arrays;

public class MinHeap {

	private int size;
	private int maxCapacity;
	private int[] minHeap;

	public MinHeap(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.size = 0;
		minHeap = new int[this.maxCapacity + 1];
		minHeap[0] = Integer.MIN_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return 2 * pos;
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private void swap(int pos1, int pos2) {
		minHeap[pos1] = minHeap[pos1] ^ minHeap[pos2];
		minHeap[pos2] = minHeap[pos1] ^ minHeap[pos2];
		minHeap[pos1] = minHeap[pos1] ^ minHeap[pos2];
	}

	private void minHeapify(int pos) {

		int left = leftChild(pos);
		int right = rightChild(pos);
		int smallest = pos;
		if (left <= size && minHeap[left] < minHeap[pos]) {
			smallest = left;
		}
		if (right <= size && minHeap[right] < minHeap[smallest]) {
			smallest = right;
		}
		if (smallest != pos) {
			swap(pos, smallest);
			minHeapify(smallest);
		}
	}

// insertion always from the leaf node
	public void insert(int value) {
		minHeap[++size] = value;
		int current = size;
		while (minHeap[current] < minHeap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public int extractMin() {
		int popped = minHeap[1];
		int last = minHeap[size];
		minHeap[1] = last;
		minHeap[size--] = popped;
		minHeapify(1);
		return popped;
	}

	public void printMinHeap() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + minHeap[i] + " LEFT CHILD : " + minHeap[2 * i] + " RIGHT CHILD :"
					+ minHeap[2 * i + 1]);
			System.out.println();
		}
	}

	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public static void main(String[] args) {

		MinHeap minHeap = new MinHeap(15);
		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);

		System.out.println(Arrays.toString(minHeap.minHeap));
		minHeap.minHeap();
		System.out.println(Arrays.toString(minHeap.minHeap));

		minHeap.printMinHeap();

		System.out.println("The min val is " + minHeap.extractMin());

		// Heap Sort Descending order
		for (int i = minHeap.size; i >= 1; i--) {
			minHeap.extractMin();
		}

		System.out.println(Arrays.toString(minHeap.minHeap));

	}
}
