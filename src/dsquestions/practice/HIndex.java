package dsquestions.practice;

public class HIndex {

    public static int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int x : citations) {
            if (x > citations.length) {
                count[citations.length]++;
            } else {
                count[x]++;
            }
        }
        int sum = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            sum += count[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(hIndex(citations));
    }
}
