package dsquestions;

public class Strstr {

	private static int strStr(String haystack, String needle) {
		if (haystack.length() == 0 && needle.length() == 0 || needle.length() == 0) {
			return 0;
		}
		char ch = needle.charAt(0);
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == ch) {
				if (checkForRemainingCharacters(haystack, needle, i + 1)) {
					return i;
				}
			}
		}
		return -1;

	}

	private static boolean checkForRemainingCharacters(String haystack, String needle, int i) {
		int start = 1;
		while (start < needle.length()) {
			if (i >= haystack.length() || haystack.charAt(i) != needle.charAt(start)) {
				return false;
			}
			start++;
			i++;
		}
		return true;

	}

	public static void main(String[] args) {
		System.err.println(strStr("hello", "ll"));
		System.err.println(strStr("abc", "bc"));
		System.err.println(strStr("", ""));
		System.err.println(strStr("aaaaa", "bba"));
		System.err.println(strStr("aaa", "aaaa"));

	}

}
