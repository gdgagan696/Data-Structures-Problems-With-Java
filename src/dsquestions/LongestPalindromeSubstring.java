package dsquestions;

public class LongestPalindromeSubstring {

	private static String longestPalindromeSubstring(String str) {

		if (str.length() <= 1) {
			return str;
		}
		int len = 1;
		int n = str.length();
		int st = 0, end = 0;
		for (int i = 0; i < n - 1; i++) {
			int l = i, r = i;
			while (l >= 0 && r < n) {
				if (str.charAt(l) == str.charAt(r)) {
					l--;
					r++;
				} else {
					break;
				}
				int templen = r - l - 1;
				if (templen > len) {
					len = templen;
					st = l + 1;
					end = r - 1;
				}
			}
		}
		for (int i = 0; i < n - 1; i++) {
			int l = i, r = i + 1;
			while (l >= 0 && r < n) {
				if (str.charAt(l) == str.charAt(r)) {
					l--;
					r++;
				} else {
					break;
				}
				int templen = r - l - 1;
				if (templen > len) {
					len = templen;
					st = l + 1;
					end = r - 1;
				}
			}
		}
		return str.substring(st, end + 1);
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubstring("ABCDDCBA"));
	}

}
