package dsquestions;

import java.util.Arrays;

public class SortArrayByParity {

	private static int[] sortArrayByParity(int[] A) {
		int[] result = new int[A.length];
		int start = 0;
		int end = A.length - 1;
		for (int x : A) {
			if (x % 2 == 0) {
				result[start] = x;
				start++;
			} else {
				result[end] = x;
				end--;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortArrayByParity(new int[] { 1, 2, 3, 4 })));
	}

}
