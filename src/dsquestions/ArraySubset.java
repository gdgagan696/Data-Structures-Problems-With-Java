package dsquestions;

import java.util.ArrayList;
import java.util.List;

public class ArraySubset {

	private static List<List<Integer>> findSubset(int[] arr) {

		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		for (int x : arr) {
			int n = result.size();
			for (int i = 0; i < n; i++) {
				ArrayList<Integer> temp = new ArrayList<>(result.get(i));
				temp.add(x);
				result.add(temp);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4 };
		List<List<Integer>> result = findSubset(arr);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
