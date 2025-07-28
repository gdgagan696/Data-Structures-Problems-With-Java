package dsquestions;

public class isPalindromeInt {

	private static boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		int reverse = 0;
		int copyX = x;
		while (copyX != 0) {
			int temp = copyX % 10;
			reverse = reverse * 10 + temp;
			copyX = copyX / 10;
		}
		return x == reverse;

	}

	public static void main(String[] args) {
		System.err.println(isPalindrome(121));
		System.err.println(isPalindrome(-121));

	}

}
