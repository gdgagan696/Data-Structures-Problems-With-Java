package dsquestions;

import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesFactors {
	public static int numFactoredBinaryTrees(int[] arr) {
		Arrays.sort(arr);
		Arrays.sort(arr);
		HashMap<Integer, Long> hs = new HashMap<>();
		long modulo = (long) (Math.pow(10, 9)) + 7;
		long total = 0;
		for (int i = 0; i < arr.length; i++) {
			hs.put(arr[i], 1L);
			int index = i - 1;
			while (index >= 0) {
				if (arr[i] % arr[index] == 0) {
					if (hs.containsKey(arr[i] / arr[index])) {
						hs.put(arr[i], (hs.get(arr[i]) + hs.get(arr[index]) * hs.get(arr[i] / arr[index])));
					}
				}
				index--;
			}
		}
		for (long val : hs.values()) {
			total += val;
		}
		return (int) (total % modulo);
	}

	public static void main(String[] args) {
		System.err.println(numFactoredBinaryTrees(new int[] { 2, 4 }));

	}

}
