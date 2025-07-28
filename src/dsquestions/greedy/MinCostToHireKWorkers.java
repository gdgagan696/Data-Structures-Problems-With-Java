//package dsquestions.greedy;
//
//import javafx.util.Pair;
//
//import java.util.*;
//
//public class MinCostToHireKWorkers {
//    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
//        List<Pair<Double, Integer>> pairs = new ArrayList<>();
//        for (int i = 0; i < quality.length; i++) {
//            pairs.add(new Pair<>((double) wage[i] / quality[i], quality[i]));
//        }
//        pairs.sort(Comparator.comparingDouble(Pair::getKey));
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        double res = Double.MAX_VALUE;
//        int total = 0;
//        for (int i = 0; i < pairs.size(); i++) {
//            pq.add(pairs.get(i).getValue());
//            total += pairs.get(i).getValue();
//            if (pq.size() > k) {
//                total -= pq.poll();
//            }
//            if (pq.size() == k) {
//                res = Math.min(res, total * pairs.get(i).getKey());
//            }
//        }
//        return res;
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2));
//    }
//}
