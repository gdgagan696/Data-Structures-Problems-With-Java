package dsquestions;

import java.util.Arrays;

public class ShortEncoding {

	private static int minimumLengthEncoding(String[] words) {
		Arrays.sort(words, (a, b) -> b.length() - a.length());
		int[] indices = new int[words.length];
		String result = words[0] + "#";
		indices[0] = 0;
		for (int i = 1; i < words.length; i++) {
			if (result.contains(words[i] + "#")) {
				int index = result.indexOf(words[i]);
				indices[i] = index;
			} else {
				result += words[i] + "#";
			}
		}
		System.err.println("Result Word:" + result);
		return result.length();

	}

	public static void main(String[] args) {
		System.err.println(minimumLengthEncoding(new String[] { "time", "me", "bell" }));
		System.err.println(minimumLengthEncoding(new String[] { "me", "time", "bell" }));
		System.err.println(minimumLengthEncoding(new String[] { "t" }));
		System.err.println(minimumLengthEncoding(new String[] { "feipyxx", "e" }));

	}

}
