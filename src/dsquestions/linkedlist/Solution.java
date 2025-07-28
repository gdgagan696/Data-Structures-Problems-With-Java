package dsquestions.linkedlist;

public class Solution {

    public static void main(String[] args) {
        String[][] input = {
                {"a", "/", "b", "/", "c"},
                {".."}
        };
        Directory dir = new Directory();
        dir.addNodes(input[0]);
        dir.removeNodes(input[1]);
        System.out.println(dir.getPWD());
    }
}

class DoublyLL {
    String dir;
    DoublyLL prev;
    DoublyLL next;

    public DoublyLL(String dir, DoublyLL prev, DoublyLL next) {
        this.dir = dir;
        this.prev = prev;
        this.next = next;
    }

    public String toString() {
        return dir;

    }
}

class Directory {
    DoublyLL head;
    DoublyLL tail;

    private void addNode(String dir) {
        if (head == null) {
            head = new DoublyLL(dir, null, null);
            tail = head;
        } else {
            tail.next = new DoublyLL(dir, tail, null);
            tail = tail.next;
        }
    }

    public void addNodes(String[] input) {
        if (input == null || input.length == 0) {
            return;
        }
        for (String ch : input) {
            if (!ch.equals("/")) {
                addNode(ch);
            }
        }
    }

    public void removeNodes(String[] input) {
        if (head == null || tail == null) {
            return;
        }
        if (input == null || input.length == 0) {
            head = null;
            tail = null;
            return;
        }
        DoublyLL end = tail;
        for (String ch : input) {
            if (!ch.equals("/")) {
                end = end.prev;
            }
        }
        end.next = null;
    }

    public String getPWD() {
        if (head == null) {
            return "/";
        }
        DoublyLL current = head;
        StringBuilder result = new StringBuilder();

        while (current != null) {
            result.append("/").append(current.dir);
            current = current.next;
        }
        return result.toString();
    }
}




/*

cd a/b/c
a->b->c
cd ../../
pwd => a
a->b->c
../../
cd
*/

