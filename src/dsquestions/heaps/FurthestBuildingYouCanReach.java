package dsquestions.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class FurthestBuildingYouCanReach {

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1]) {
                q.add(heights[i] - heights[i - 1]);
                if (q.size() > ladders) {
                    bricks -= q.poll();
                }
            }
            if (bricks < 0) {
                return i - 1;
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
    }

}
