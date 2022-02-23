package dsquestions.graphs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {

        if (node == null) return node;
        Map<Integer, Node> hm = new LinkedHashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            Node nodeFromMap = hm.get(temp.val);
            List<Node> neighbours = null;
            if (nodeFromMap != null) {
                neighbours = nodeFromMap.neighbors;
            } else {
                Node newNode = new Node(temp.val);
                hm.put(temp.val, newNode);
                neighbours = newNode.neighbors;
            }
            for (Node edge : temp.neighbors) {
                Node edgeFromMap = hm.get(edge.val);
                if (edgeFromMap != null) {
                    if (!neighbours.contains(edgeFromMap)) {
                        neighbours.add(edgeFromMap);
                    }
                } else {
                    queue.add(edge);
                    Node newNode = new Node(edge.val);
                    hm.put(edge.val, newNode);
                    neighbours.add(newNode);
                }
            }
        }
        return hm.get(1);
    }
}
