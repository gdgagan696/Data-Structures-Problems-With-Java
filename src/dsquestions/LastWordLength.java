package dsquestions;

public class LastWordLength {

	private static int lengthOfLastWord(String s) {
		s = s.trim();
		if (s.length() == 0) {
			return 0;
		}
		String[] string = s.split(" ");

		if (!string[string.length - 1].equals(" ")) {
			return string[string.length - 1].length();
		}

		return 0;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("hello world"));

	}

}
