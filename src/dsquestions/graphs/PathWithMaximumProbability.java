package dsquestions.graphs;

import java.util.*;

class Graph {

    int source;
    int destination;
    double prob;

    public Graph(int source, int destination, double prob) {

        this.source = source;
        this.destination = destination;
        this.prob = prob;
    }
}

public class PathWithMaximumProbability {

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer, List<Graph>> hm = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            hm.putIfAbsent(edge[0], new ArrayList<>());
            hm.putIfAbsent(edge[1], new ArrayList<>());
            hm.get(edge[0]).add(new Graph(edge[0], edge[1], succProb[i]));
            hm.get(edge[1]).add(new Graph(edge[0], edge[0], succProb[i]));
        }
        double[] maxProb = new double[n];
        maxProb[start_node] = 1d;
        PriorityQueue<Graph> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Graph(start_node, -1, 1));
        while (!pq.isEmpty()) {
            Graph temp = pq.poll();
            if (temp.source == end_node) {
                return temp.prob;
            }
            for (Graph next : hm.getOrDefault(temp.source,new ArrayList<>())) {
                if (temp.prob * next.prob > maxProb[next.destination]) {
                    maxProb[next.destination] = temp.prob * next.prob;
                    pq.add(new Graph(next.destination, -1, temp.prob * next.prob));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int n = 10;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0, end = 2;
        System.out.println(maxProbability(n, edges, succProb, start, end));
    }

}
