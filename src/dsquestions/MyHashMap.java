package dsquestions;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {

	public class Node {
		int key;
		int value;
		Node next;

		Node(int key, int value) {
			this.key = key;
			this.value = value;

		}
	}

	int capacity;
	int size;
	List<Node> buckets;

	public MyHashMap() {
		capacity = 16;
		buckets = new ArrayList<>();
		for (int i = 0; i < capacity; i++) {
			buckets.add(null);
		}

	}

	public int getSize() {
		return size;
	}

	public void put(int key, int value) {
		int hashIndex = hashFunction(key);
		Node head = buckets.get(hashIndex);
		while (head != null) {
			if (head.key == key) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		head = buckets.get(hashIndex);
		Node newNode = new Node(key, value);
		size++;
		newNode.next = head;
		buckets.set(hashIndex, newNode);

	}

	public int get(int key) {
		int hashIndex = hashFunction(key);
		Node head = buckets.get(hashIndex);
		while (head != null) {
			if (head.key == key) {
				return head.value;
			}
			head = head.next;
		}
		return -1;
	}

	public void remove(int key) {

		int hashIndex = hashFunction(key);
		Node head = buckets.get(hashIndex);
		Node previousNode = null;
		while (head != null) {
			if (head.key == key) {
				if (previousNode == null) {
					buckets.set(hashIndex, head.next);
				} else {
					previousNode.next = head.next;
				}
				size--;
			}
			previousNode = head;
			head = head.next;
		}

	}

	public int hashFunction(Integer key) {
		int hashCode = key.hashCode();
		return hashCode % capacity;
	}

	public static void main(String[] args) {
		MyHashMap myHashMap = new MyHashMap();
		myHashMap.put(1, 1);
		myHashMap.put(2, 2);
		myHashMap.put(3, 3);
		myHashMap.put(4, 4);
		myHashMap.put(20, 6);

		System.err.println(myHashMap.get(4));
		System.err.println(myHashMap.get(20));
		System.err.println(myHashMap.getSize());
		System.err.println(myHashMap.get(1));

		myHashMap.remove(4);

		System.err.println(myHashMap.getSize());
		System.err.println(myHashMap.get(4));
		System.err.println(myHashMap.get(20));

	}

}
