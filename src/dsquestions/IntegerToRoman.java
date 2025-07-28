package dsquestions;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

	private static String intToRoman(int num) {
		Map<Integer, String> romans = new HashMap<>();
		int allBases[] = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		fillMap(romans);
		String result = "";
		for (int base : allBases) {
			while (num >= base) {
				num -= base;
				result += romans.get(base);
			}
		}

		return result;

	}

	private static void fillMap(Map<Integer, String> romans) {
		romans.put(1, "I");
		romans.put(4, "IV");
		romans.put(5, "V");
		romans.put(9, "IX");
		romans.put(10, "X");
		romans.put(40, "XL");
		romans.put(50, "L");
		romans.put(90, "XC");
		romans.put(100, "C");
		romans.put(400, "CD");
		romans.put(500, "D");
		romans.put(900, "CM");
		romans.put(1000, "M");
	}

	public static void main(String[] args) {
		System.err.println(intToRoman(70));
		System.err.println(intToRoman(1994));

	}

}
