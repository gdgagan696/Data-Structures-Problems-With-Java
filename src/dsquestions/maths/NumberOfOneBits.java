package dsquestions.maths;

public class NumberOfOneBits {

    public static int hammingWeight(int n) {

        int res = 0;
        while (n != 0) {
            res++;
            n = n & n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
