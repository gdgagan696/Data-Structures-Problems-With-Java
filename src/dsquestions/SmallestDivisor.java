package dsquestions;

public class SmallestDivisor {

	public static int smallestDivisor(int[] nums, int threshold) {
		int l = 1, r = 1000000;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			long sum = getSum(nums, mid);
			if (sum > threshold) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;

	}

	private static long getSum(int[] nums, int divisor) {
		int sum = 0;
		for (int x : nums) {
			sum += Math.ceil((double) x / divisor);
		}
		return sum;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 5, 9 };
		System.out.println(smallestDivisor(arr, 6));

	}

}
