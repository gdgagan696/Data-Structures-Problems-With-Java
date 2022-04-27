package dsquestions.graphs;

import java.util.*;

public class SmallestStringWithSwaps {

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        int[] parent = new int[s.length()];
        Arrays.setAll(parent, i -> i);
        for (List<Integer> pair : pairs) {
            unionFind(pair.get(0), pair.get(1), parent);
        }
        HashMap<Integer, List<Character>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int par = find(i, parent);
            List<Character> list = map.getOrDefault(par, new ArrayList<>());
            list.add(s.charAt(i));
            map.put(par, list);
        }

        for (List<Character> a : map.values()) {
            a.sort((x, y) -> y - x);
        }

        char[] ch = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int par = find(i, parent);
            ch[i] = map.get(par).remove(map.get(par).size() - 1);
        }

        return new String(ch);


    }

    private static void unionFind(int x, int y, int[] parent) {
        int parX = find(x, parent);
        int parY = find(y, parent);
        if (parX != parY) {
            parent[parY] = parX;
        }
    }

    private static int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 3));
        pairs.add(Arrays.asList(1, 2));
        pairs.add(Arrays.asList(0, 2));
        System.out.println(smallestStringWithSwaps(s, pairs));
    }
}
