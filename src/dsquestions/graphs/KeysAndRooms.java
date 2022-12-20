package dsquestions.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        List<Integer> keys = new ArrayList<>();
        keys.addAll(rooms.get(0));

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            visited[temp] = true;
            for (int x : rooms.get(temp)) {
                if (!visited[x])
                    queue.add(x);
            }
        }
        for (boolean value : visited) {
            if (!value) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());
        System.out.println(canVisitAllRooms(rooms));
    }
}
