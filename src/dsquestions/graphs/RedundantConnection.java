package dsquestions.graphs;

public class RedundantConnection {
    int n;
    int[] parent;

    public RedundantConnection(int n) {
        this.n = n;
        this.parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    public int union(int x, int y) {
        int xPar = find(x);
        int yPar = find(y);
        if (xPar == yPar) {
            return 0;
        }
        parent[xPar] = yPar;
        this.n--;
        return 1;
    }


    public int[] findRedundantConnection(int[][] edges) {
        RedundantConnection redundantConnection = new RedundantConnection(edges.length);
        int[] res = new int[2];
        for (int[] edge : edges) {
            int temp = redundantConnection.union(edge[0], edge[1]);
            if (temp == 0) {
                res[0] = edge[0];
                res[1] = edge[1];
            }
        }
        return res;

    }
}
