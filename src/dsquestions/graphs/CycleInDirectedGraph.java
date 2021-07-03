package dsquestions.graphs;

import java.util.ArrayList;

public class CycleInDirectedGraph {
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[] = new boolean[V];
        boolean rec[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (isCyclic(adj, i, visited, rec)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, boolean[] rec) {
        if (rec[src]) return true;
        if (visited[src]) return false;
        rec[src] = true;
        visited[src] = true;
        for (int edge : adj.get(src)) {
            if (isCyclic(adj, edge, visited, rec)) {
                return true;
            }
        }
        rec[src] = false;
        return false;
    }
}
