package dsquestions.arrays;

public class TeemoAttacking {

    public static int findPoisonedDuration(int[] timeSeries, int duration) {

        int start = timeSeries[0];
        int last = timeSeries[0] + duration - 1;
        int total = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int x = timeSeries[i];
            if (last >= x) {
                total += x - start;

            } else {
                total += last - start + 1;
            }
            start = x;
            last = x + duration - 1;
        }
        total += last - start + 1;
        return total;
    }

    public static void main(String[] args) {

        int[] timeSeries = {1, 4};
        int duration = 2;
        System.out.println(findPoisonedDuration(timeSeries, duration));
    }

}
