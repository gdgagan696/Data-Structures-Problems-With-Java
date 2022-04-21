package dsquestions;

public class MyHashSet {
    Integer[] hashSet;
    int capacity;

    public MyHashSet() {
        capacity = 1000000;
        hashSet = new int[capacity];
    }

    public void add(int key) {
        int index = key % capacity;
        hashSet[index] = key;

    }

    public void remove(int key) {
        int index = key % capacity;
        hashSet[index] = null;
    }

    public boolean contains(int key) {
        int index = key % capacity;
        return hashSet[index] != null;
    }
}
