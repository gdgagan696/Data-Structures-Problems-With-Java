package dsquestions;

public class ValidPalindrome {

	private static boolean isPalindrome(String s) {

		if (s == null)
			return false;

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {

			if (!Character.isLetterOrDigit(s.charAt(start))) {
				start++;
			} else if (!Character.isLetterOrDigit(s.charAt(end))) {
				end--;
			} else if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
				return false;
			} else {
				start++;
				end--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String input1 = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(input1));
		String input2 = "race a car";
		System.out.println(isPalindrome(input2));

	}

}
