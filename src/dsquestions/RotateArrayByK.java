package dsquestions;

import java.util.Arrays;

public class RotateArrayByK {

	private static void reverseArray(int arr[], int low, int high) {
		for (int i = low, j = high; i < j; i++, j--) {
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j];
			arr[i] = arr[i] ^ arr[j];
		}
	}

	private static void rotateArray(int arr[], int k) {

		reverseArray(arr, k, arr.length - 1);
		reverseArray(arr, 0, k - 1);
		reverseArray(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };
		rotateArray(arr, 2);
		System.out.println(Arrays.toString(arr));
	}

}
