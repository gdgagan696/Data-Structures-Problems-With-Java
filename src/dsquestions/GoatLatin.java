package dsquestions;

public class GoatLatin {

	private static String toGoatLatin(String S) {

		if (S.length() == 0) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		StringBuilder sa = new StringBuilder();
		sa.append("a");
		String[] temp = S.split(" ");
		for (int i = 0; i < temp.length; i++) {
			if (isVowel(temp[i].charAt(0))) {
				result = result.append(temp[i]).append("ma").append(sa.toString()).append(" ");
				sa.append("a");
			} else {
				result = result.append(temp[i].substring(1)).append(temp[i].charAt(0)).append("ma")
						.append(sa.toString()).append(" ");
				sa.append("a");
			}
		}
		return result.toString().trim();

	}

	private static boolean isVowel(char ch) {
		ch = Character.toLowerCase(ch);
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}

	public static void main(String[] args) {
		System.out.println(toGoatLatin("I speak Goat Latin"));
		System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
	}

}
