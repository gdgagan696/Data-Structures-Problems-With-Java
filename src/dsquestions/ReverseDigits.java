package dsquestions;

public class ReverseDigits {
	private static int reverse(int x) {
		long reversed = 0;
		while (x != 0) {
			int digit = x % 10;
			reversed = reversed * 10 + digit;
			x /= 10;
		}
		return (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) ? 0 : (int) reversed;
	}

	public static void main(String[] args) {
		System.err.println(reverse(1534236469));
		System.err.println(reverse(123));

	}

}
