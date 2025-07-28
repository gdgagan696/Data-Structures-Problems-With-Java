package dsquestions.maths;

public class PivotInteger {
    public static int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int curr = 0;
        for (int i = 1; i <= n; i++) {
            curr += i;
            int temp = sum - curr + i;
            if (temp == curr) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
        System.out.println(pivotInteger(1));
    }
}
