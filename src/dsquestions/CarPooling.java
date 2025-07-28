package dsquestions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CarPooling {

    static class PoolInfo {
        public int start;
        public int end;
        public int passenger;

        public PoolInfo(int passenger, int start, int end) {
            this.passenger = passenger;
            this.start = start;
            this.end = end;
        }

    }

    public static boolean carPooling(int[][] trips, int capacity) {

        List<PoolInfo> poolInfo = new ArrayList<>();
        for (int arr[] : trips) {
            poolInfo.add(new PoolInfo(arr[0], arr[1], arr[2]));
        }
        poolInfo.sort(Comparator.comparingInt(a -> a.start));
        PriorityQueue<PoolInfo> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        for (int i = 0; i < poolInfo.size(); i++) {

            PoolInfo tempPoolInfo = poolInfo.get(i);
            while (pq.size() > 0 && pq.peek().end <= tempPoolInfo.start){
                capacity += pq.remove().passenger;
            }

            if (tempPoolInfo.passenger <= capacity) {
                pq.add(tempPoolInfo);
                capacity -= tempPoolInfo.passenger;
            } else {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {
                {2, 1, 5}, {3, 5, 7}
        };
        System.out.println(carPooling(trips, 3));
    }
}
