package dsquestions.dp;

public class FibonacciNumber {
    public static int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        int prev = 0;
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            int temp = ans;
            ans = ans + prev;
            prev = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
    }

}