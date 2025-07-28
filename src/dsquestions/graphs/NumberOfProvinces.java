package dsquestions.graphs;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] isConnected) {

        boolean visited[] = new boolean[isConnected.length];
        int total = 0;
        for (int i = 0; i < isConnected.length; i++)
            if (!visited[i]) {
                total += findCircleNumUtil(isConnected, i, visited);
            }
        return total;

    }

    private static int findCircleNumUtil(int[][] isConnected, int src, boolean[] visited) {

        visited[src] = true;
        int[] edges = isConnected[src];
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == 1 && !visited[i]) {
                findCircleNumUtil(isConnected, i, visited);
            }
        }
        return 1;
    }

    public static void main(String[]args){
        int [][]isConnected={
                {1,0,0},{0,1,0},{0,0,1}
        };
        System.out.println(findCircleNum(isConnected));
    }
}
