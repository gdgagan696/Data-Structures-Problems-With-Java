package dsquestions;

public class ExcelSheetColumnNumber {
	
	private static int titleToNumber(String s) {
		int result = 0;
		for (char c : s.toCharArray()) {
			result = result * 26 + (c - 'A') + 1;
		}
		return result;
	}
	

	public static void main(String[] args) {

		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("AB"));
		System.out.println(titleToNumber("ZY"));
		System.out.println(titleToNumber("ZY"));

	}

}
