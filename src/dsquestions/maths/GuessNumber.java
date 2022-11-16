package dsquestions.maths;

public class GuessNumber {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int guessOutput = guess(mid);
            if (guessOutput == 0) {
                return mid;
            } else if (guessOutput == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int guess(int num) {
        return 1;
    }
}
