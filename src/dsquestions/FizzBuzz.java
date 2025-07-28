package dsquestions;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	private static List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		String multipleOf3Text = "Fizz";
		String multipleOf5Text = "Buzz";
		String multipleOf3And5Text = "FizzBuzz";
		for (int i = 1; i <= n; i++) {
			String temp = new String(String.valueOf(i));
			if (isMultipleOf3And5(i)) {
				temp = multipleOf3And5Text;
			} else {
				if (isMultipleOf3(i)) {
					temp = multipleOf3Text;
				}
				if (isMultipleOf5(i)) {
					temp = multipleOf5Text;
				}
			}
			result.add(temp);
		}
		return result;

	}

	private static boolean isMultipleOf3(int n) {
		return n % 3 == 0;
	}

	private static boolean isMultipleOf5(int n) {
		return n % 5 == 0;
	}

	private static boolean isMultipleOf3And5(int n) {
		return isMultipleOf3(n) && isMultipleOf5(n);
	}

	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}

}
