package dsquestions.graphs;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        for (int i = 0; i < points.length; i++) {
            int d = getDistance(points[0], points[i]);
            int[] distanceDiff = {0, i, d};
            queue.add(distanceDiff);
        }

        boolean[] visited = new boolean[points.length];
        visited[0] = true;

        int count = points.length - 1;
        int cost = 0;

        while (!queue.isEmpty() && count > 0) {
            int[] currCostDetails = queue.poll();

            int node = currCostDetails[1];
            int distanceCost = currCostDetails[2];

            if (!visited[node]) {

                visited[node] = true;
                cost += distanceCost;
                count--;

                for (int i = 0; i < points.length; i++) {
                    int d = getDistance(points[node], points[i]);
                    int[] distanceDiff = {node, i, d};
                    queue.add(distanceDiff);
                }

            }
        }

        return cost;
    }

    private int getDistance(int[] a, int[] b) {

        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}

