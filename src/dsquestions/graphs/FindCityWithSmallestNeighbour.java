package dsquestions.graphs;

import java.util.*;

public class FindCityWithSmallestNeighbour {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        int INF = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            Arrays.fill(mat[i], INF);
            mat[i][i] = 0;
        }
        for (int[] edge : edges) {
            mat[edge[0]][edge[1]] = edge[2];
            mat[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }
        int minCount = INF;
        int city = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (minCount >= count) {
                minCount = count;
                city = i;
            }
        }
        return city;
    }
}
