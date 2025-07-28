package dsquestions;

public class HIndex {

	private static int hIndex(int[] citations) {
		int[] frequencyMap = new int[citations.length + 1];
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] > citations.length) {
				frequencyMap[citations.length]++;
			} else {
				frequencyMap[citations[i]]++;
			}
		}
		int count = 0;
		for (int i = frequencyMap.length - 1; i > 00; i--) {
			count += frequencyMap[i];
			if (count >= i) {
				return i;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int arr[] = { 3, 0, 6, 1, 5 };	//unsorted array
		System.out.print(hIndex(arr));
	}

}
