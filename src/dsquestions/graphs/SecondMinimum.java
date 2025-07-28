package dsquestions.graphs;

import java.util.*;

class SecondMinimum {
    public static int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            g.computeIfAbsent(v, x -> new ArrayList<>()).add(u);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0});
        int[] uniqueVisit = new int[n + 1];
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], t = cur[1];
            if (dis[node] == t || uniqueVisit[node] >= 2) continue;
            uniqueVisit[node]++;
            dis[node] = t;
            if (node == n && uniqueVisit[node] == 2) return dis[node];

            if ((t / change) % 2 == 1) {
                t += change - (t % change);
            }
            for (int nei : g.getOrDefault(node, new ArrayList<>())) {
                q.offer(new int[]{nei, t + time});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        int time = 3;
        int change = 5;
        System.out.println(secondMinimum(n, edges, time, change));
    }
}
