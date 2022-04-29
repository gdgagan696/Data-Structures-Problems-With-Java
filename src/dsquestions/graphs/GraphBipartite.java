package dsquestions.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBipartite {

    public boolean isBipartite(int[][] graph) {

        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (!isGraphBipartite(graph, i)) {
                    return false;
                }
            }
        }
        return true;


    }

    private boolean isGraphBipartite(int[][] graph, int src) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        color[src] = 1;
        while (queue.size() > 0) {
            int vertex = queue.poll();
            for (int edge : graph[vertex]) {
                if (color[edge] == -1) {
                    color[edge] = 1 - color[vertex];
                    queue.add(edge);
                } else if (color[edge] == color[vertex]) {
                    return false;
                }
            }
        }
        return true;
    }
}
