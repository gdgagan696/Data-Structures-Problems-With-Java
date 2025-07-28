package dsquestions;

public class MissingNumber {

	private static int missingNumber(int[] nums) {
		int n = nums.length;
		long actualSum = n * (n + 1) / 2;
		long errorSum = 0;
		for (int num : nums)
			errorSum += num;

		return (int) (actualSum - errorSum);
	}

	public static void main(String[] args) {
		System.err.println(missingNumber(new int[] { 3, 0, 1 }));

	}

}
