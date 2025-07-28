package dsquestions;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class RightInterval {

	private static int[] findRightInterval(int[][] intervals) {
		TreeMap<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();
		int[] res = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			if (!treeMap.containsKey(intervals[i][0])) {
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				pq.add(i);
				treeMap.put(intervals[i][0], pq);
			} else {
				treeMap.get(intervals[i][0]).add(i);
			}
		}
		for (int i = 0; i < intervals.length; i++) {
			Integer key = treeMap.ceilingKey(intervals[i][1]);
			res[i] = key != null ? treeMap.get(key).peek() : -1;
		}
		return res;
	}

	public static void main(String[] args) {

		int[][] input = { { 1, 2 }, { 2, 3 }, { 0, 1 }, { 3, 4 } };
		System.out.println(Arrays.toString(findRightInterval(input)));

	}

}
