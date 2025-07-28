package dsquestions.graphs;

public class RemoveMaxNodes {
    int n;
    int[] parent;

    public RemoveMaxNodes(int n) {
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

    boolean isConnected() {
        return n == 1;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        RemoveMaxNodes alice = new RemoveMaxNodes(n);
        RemoveMaxNodes bob = new RemoveMaxNodes(n);
        int count = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                count += (alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2]));
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                count += alice.union(edge[1], edge[2]);
                ;
            } else if (edge[0] == 2) {
                count += bob.union(edge[1], edge[2]);
            }
        }
        if (alice.isConnected() && bob.isConnected()) {
            return edges.length - count;
        }
        return -1;
    }
}
