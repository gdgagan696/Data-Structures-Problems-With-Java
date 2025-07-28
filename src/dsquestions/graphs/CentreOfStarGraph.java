package dsquestions.graphs;

import java.util.HashMap;
import java.util.Map;

public class CentreOfStarGraph {
    public static int findCenter(int[][] edges) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int[] edge : edges) {
            hm.put(edge[1], hm.getOrDefault(edge[1], 0) + 1);
            hm.put(edge[0], hm.getOrDefault(edge[0], 0) + 1);
        }
        for (int key : hm.keySet()) {
            if (hm.get(key)==edges.length) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[]args){
        int[][]edges={
                {1,2},{5,1},{1,3},{1,4}
        };
        System.out.println(findCenter(edges));
    }
}
