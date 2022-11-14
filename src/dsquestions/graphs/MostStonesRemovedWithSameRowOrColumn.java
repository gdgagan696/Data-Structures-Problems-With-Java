package dsquestions.graphs;

public class MostStonesRemovedWithSameRowOrColumn {
    public static int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind(stones.length);
        for (int i = 0; i < stones.length - 1; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                int[] stone1 = stones[i];
                int[] stone2 = stones[j];
                if (stone1[0] == stone2[0] || stone1[1] == stone2[1]) {
                    unionFind.union(i, j);
                }
            }
        }
        return stones.length - unionFind.countComponents();

    }

    static class UnionFind {
        int parent[];
        int rank[];

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return find(parent[x]);
        }

        public void union(int x, int y) {
            int parent1 = find(x);
            int parent2 = find(y);
            parent[parent1] = parent2;
        }

        public int countComponents() {
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (i == parent[i]) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        System.out.println(removeStones(stones));
    }
}
