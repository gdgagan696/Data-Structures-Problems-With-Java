package dsquestions.greedy;

public class SmallestStringWithGivenValue {
    public static String getSmallestString(int n, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int val = k - (i - 1);
            if (val >= 26) {
                res.append("z");
                k -= 26;
            } else {
                res.append((char) (val - 1 + 'a'));
                k -= val;
            }
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString(3, 27));
    }
}
