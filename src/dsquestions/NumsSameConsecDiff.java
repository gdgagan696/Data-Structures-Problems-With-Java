package dsquestions;

import java.util.ArrayList;
import java.util.Arrays;

public class NumsSameConsecDiff {

	private static int[] numsSameConsecDiff(int N, int K) {
		int arr[] = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		if (N == 1) {
			return arr;
		}
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			generate(N, K, i, 0, i, res);
		}
		return res.stream().mapToInt(i -> i).toArray();

	}

	private static void generate(int N, int K, int cur, int i, int prev, ArrayList<Integer> res) {
		if (i == N - 1) {
			res.add(cur);
			return;
		}
		int next = prev + K;
		if (next < 10) {
			generate(N, K, cur * 10 + next, i + 1, next, res);
		}
		next = prev - K;

		if (K != 0 && next >= 0) {
			generate(N, K, (cur * 10) + next, i + 1, next, res);
		}
	}

	public static void main(String[] args) {

		System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
		System.out.println(Arrays.toString(numsSameConsecDiff(2, 1)));
	}

}
