package dsquestions.maths;

public class FractionAdditionSubtraction {
    public static String fractionAddition(String expression) {
        int i = 0;
        int num = 0;
        int den = 1;
        while (i < expression.length()) {
            boolean isNeg = expression.charAt(i) == '-';
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                i++;
            }
            int currNum = 0;
            int currDen = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currNum = currNum * 10 + val;
                i++;
            }
            if (isNeg) {
                currNum = -1 * currNum;
            }
            i++;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currDen = currDen * 10 + val;
                i++;
            }
            num = num * currDen + den * currNum;
            den = currDen * den;
        }
        int gcd = Math.abs(gcd(num, den));
        num /= gcd;
        den /= gcd;
        return num + "/" + den;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        System.out.println(fractionAddition("-1/2+1/2"));
        System.out.println(fractionAddition("1/3-1/2"));
    }
}
