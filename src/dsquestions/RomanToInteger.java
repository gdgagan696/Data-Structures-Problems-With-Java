package dsquestions;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	private static int romanToInt(String s) {
		Map<String, Integer> romans = new HashMap<>();
		fillMap(romans);
		int result = 0;
		for (int i = 0; i < s.length();) {
			if (i + 2 <= s.length() && romans.containsKey(s.substring(i, i + 2))) {
				result += romans.get(s.substring(i, i + 2));
				i += 2;
			} else {
				result += romans.get(String.valueOf(s.charAt(i)));
				i++;

			}
		}

		return result;

	}

	private static void fillMap(Map<String, Integer> romans) {
		romans.put("I", 1);
		romans.put("IV", 4);
		romans.put("V", 5);
		romans.put("IX", 9);
		romans.put("X", 10);
		romans.put("XL", 40);
		romans.put("L", 50);
		romans.put("XC", 90);
		romans.put("C", 100);
		romans.put("CD", 400);
		romans.put("D", 500);
		romans.put("CM", 900);
		romans.put("M", 1000);
	}

	public static void main(String[] args) {
		System.err.println(romanToInt("MCMXCIV"));

	}

}
