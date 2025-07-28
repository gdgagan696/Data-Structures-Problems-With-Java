package dsquestions;

public class RemovePalindrome {

	private static int removePalindromeSub(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int min = 1000;
		if (isPalindrome(s)) {
			min = 1;
		}
		for (int i = 0; i < s.length(); i++) {
			int temp = 1;
			if (isPalindrome(s.substring(i + 1))) {
				temp += 1;
				if (temp < min) {
					min = temp;
				}
			}

		}
		return min;

	}

	private static boolean isPalindrome(String s) {
		if (new StringBuilder(s).reverse().toString().equals(s)) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.err.println(removePalindromeSub("ababa"));

	}

}
