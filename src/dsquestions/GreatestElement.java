package dsquestions;

import java.util.Arrays;

public class GreatestElement {

	public static int greatestElement(int n) {
		char[] charArray = String.valueOf(n).toCharArray();
		int i, j;
		for (i = charArray.length - 1; i > 0; i--) {
			if (charArray[i - 1] < charArray[i]) {
				break;
			}
		}
		if (i == 0)
			return -1;
		int num = charArray[i - 1];
		int min = i;
		for (j = i + 1; j < charArray.length; j++) {
			if (charArray[j] > num && charArray[j] < charArray[min]) {
				min = j;
			}
		}

		char num1 = charArray[i - 1];
		charArray[i - 1] = charArray[min];
		charArray[min] = num1;
		Arrays.sort(charArray, i, charArray.length);
		long val = Long.parseLong(new String(charArray));
		return (val <= Integer.MAX_VALUE) ? (int) val : -1;
	}

	public static void main(String[] args) {
		System.out.println(greatestElement(534976));
	}

}
