package dsquestions;

public class DetectCapital {

	private static boolean detectCapitalUse(String word) {
		int c = 0;
		for (int i = 0; i < word.length(); i++) {
			if (Character.isUpperCase(word.charAt(i)))
				c++;
		}
		if (c == 0 || c == word.length()) {
			return true;
		} else {
			return c == 1 && Character.isUpperCase(word.charAt(0));
		}

	}

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("Gagan"));
		System.out.println(detectCapitalUse("gagan"));
		System.out.println(detectCapitalUse("GAGAN"));
		System.out.println(detectCapitalUse("GAgAN"));

	}

}
