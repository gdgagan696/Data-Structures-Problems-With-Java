package dsquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSorting {

	public static List<Integer> pancakeSort(int[] A) {

		int len = A.length;
		List<Integer> result = new ArrayList<>();
		for (int i = len; i > 1; i--) {
			int maxIndex = findMax(A, i);
			if (maxIndex != i - 1) {
				result.add(maxIndex + 1);
				flip(A, maxIndex);
				result.add(i);
				flip(A, i - 1);

			}
		}
		return result;

	}

	private static void flip(int arr[], int index) {
		int temp, start = 0;
		while (start < index) {
			temp = arr[start];
			arr[start] = arr[index];
			arr[index] = temp;
			start++;
			index--;
		}
	}

	private static int findMax(int arr[], int n) {
		int index = 0;
		for (int i = 1; i < n; i++)
			if (arr[i] > arr[index])
				index = i;
		return index;
	}

	public static void main(String[] args) {

		int arr[] = new int[] { 3, 2, 4, 1 };
		System.out.println(pancakeSort(arr));
		System.out.println(Arrays.toString(arr));
	}

}
