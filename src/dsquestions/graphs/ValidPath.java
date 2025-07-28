package dsquestions.graphs;

import java.util.*;

public class ValidPath {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[]visited=new boolean[n];
        for (int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source]=true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                return true;
            }
            for (int neighbour : adj.get(node)) {
                if(!visited[neighbour]) {
                    visited[neighbour]=true;
                    queue.add(neighbour);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0}
        };
        System.out.println(validPath(3, edges, 0, 2));
    }
}
