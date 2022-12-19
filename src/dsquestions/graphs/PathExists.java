package dsquestions.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class PathExists {

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> hm = new HashMap<>();
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        for (int[] mat : edges) {
            hm.compute(mat[0], (key, value) -> {
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(mat[1]);
                return value;
            });
            hm.compute(mat[1], (key, value) -> {
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(mat[0]);
                return value;
            });
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (temp == destination) {
                return true;
            }
            for (int x : hm.get(temp)) {
                if (!visited[x]) {
                    queue.add(x);
                    visited[x] = true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}};
        System.out.println(validPath(3, edges, 0, 2));
    }
}
