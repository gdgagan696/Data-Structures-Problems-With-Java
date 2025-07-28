package dsquestions;

import java.util.ArrayList;

public class Substring {

	private static ArrayList<String> getSubString(String str) {
		if (str.length() == 0) {
			ArrayList<String> temp = new ArrayList<>();
			temp.add("");
			return temp;
		}
		char ch = str.charAt(0);
		String remaining = str.substring(1);
		ArrayList<String> result = new ArrayList<>();
		ArrayList<String> recresult = getSubString(remaining);
		for (int i = 0; i < recresult.size(); i++) {
			result.add(recresult.get(i));
			result.add(ch + recresult.get(i));

		}

		return result;
	}

	public static void main(String[] args) {

		System.out.println(getSubString("xyz"));

	}

}
