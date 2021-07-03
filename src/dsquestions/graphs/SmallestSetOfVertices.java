package dsquestions.graphs;

import java.util.*;

public class SmallestSetOfVertices {
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (List<Integer> edge : edges) {
            set.add(edge.get(1));
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(2, 1));
        edges.add(Arrays.asList(3, 1));
        edges.add(Arrays.asList(1, 4));
        edges.add(Arrays.asList(2, 4));
        System.out.println(findSmallestSetOfVertices(5, edges));
    }
}
