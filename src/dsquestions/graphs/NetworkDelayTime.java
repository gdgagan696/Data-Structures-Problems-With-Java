package dsquestions.graphs;

import java.util.*;

public class NetworkDelayTime {
    static class Edge {
        int v;
        int w;

        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Edge>> map = new HashMap<>();

        for (int[] arr : times) {
            List<Edge> edges = map.getOrDefault(arr[0], new ArrayList<>());
            edges.add(new Edge(arr[1], arr[2]));
            map.put(arr[0], edges);
        }

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        queue.add(new Edge(k, 0));
        Set<Integer> visited = new HashSet<>();
        int time = 0;
        while (!queue.isEmpty()) {
            Edge temp = queue.poll();
            if (visited.contains(temp.v)) continue;
            visited.add(temp.v);
            time = temp.w;

            for (Edge edge : map.getOrDefault(temp.v, new ArrayList<>())) {
                queue.add(new Edge(edge.v, time + edge.w));
            }
        }
        return visited.size() == n ? time : -1;
    }

    public static void main(String[] args) {
        int[][] times = {
                {2, 1, 1}, {2, 3, 1}, {3, 4, 1}
        };
        System.out.println(networkDelayTime(times, 4, 2));
    }
}
