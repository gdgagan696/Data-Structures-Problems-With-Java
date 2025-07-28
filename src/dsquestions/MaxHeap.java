package dsquestions;

import java.util.Arrays;

public class MaxHeap {

	private int size;
	private int maxCapacity;
	private int[] maxHeap;

	public MaxHeap(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.size = 0;
		maxHeap = new int[this.maxCapacity + 1];
		maxHeap[0] = Integer.MAX_VALUE;
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
		maxHeap[pos1] = maxHeap[pos1] ^ maxHeap[pos2];
		maxHeap[pos2] = maxHeap[pos1] ^ maxHeap[pos2];
		maxHeap[pos1] = maxHeap[pos1] ^ maxHeap[pos2];
	}

	private void maxHeapify(int pos) {

		int left = leftChild(pos);
		int right = rightChild(pos);
		int largest = pos;
		if (left <= size && maxHeap[left] > maxHeap[pos]) {
			largest = left;
		}
		if (right <= size && maxHeap[right] > maxHeap[largest]) {
			largest = right;
		}
		if (largest != pos) {
			swap(pos, largest);
			maxHeapify(largest);
		}
	}

	// insertion always from the leaf node
	public void insert(int value) {
		maxHeap[++size] = value;
		int current = size;
		while (maxHeap[current] > maxHeap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	public int extractMax() {
		int popped = maxHeap[1];
		int last = maxHeap[size];
		maxHeap[1] = last;
		maxHeap[size--] = popped;
		maxHeapify(1);
		return popped;
	}

	public void printMaxHeap() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + maxHeap[i] + " LEFT CHILD : " + maxHeap[2 * i] + " RIGHT CHILD :"
					+ maxHeap[2 * i + 1]);
			System.out.println();
		}
	}

	public void maxHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			maxHeapify(pos);
		}
	}

	public static void main(String[] args) {

		MaxHeap maxHeap = new MaxHeap(15);
		maxHeap.insert(5);
		maxHeap.insert(3);
		maxHeap.insert(17);
		maxHeap.insert(10);
		maxHeap.insert(84);
		maxHeap.insert(19);
		maxHeap.insert(6);
		maxHeap.insert(22);
		maxHeap.insert(9);

		System.out.println(Arrays.toString(maxHeap.maxHeap));

		maxHeap.printMaxHeap();

		System.out.println("The max val is " + maxHeap.extractMax());

		// Heap Sort Ascending order
		for (int i = maxHeap.size; i >= 1; i--) {
			maxHeap.extractMax();
		}

		System.out.println(Arrays.toString(maxHeap.maxHeap));

	}

}
