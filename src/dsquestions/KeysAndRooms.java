package dsquestions;

import java.util.*;

public class KeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
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
        List<Integer> r1 = Arrays.asList(1, 3);
        List<Integer> r2 = Arrays.asList(3, 0, 1);
        List<Integer> r3 = Arrays.asList(2);
        List<Integer> r4 = Arrays.asList(0);
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);

        System.out.println(canVisitAllRooms(rooms));
    }
}
