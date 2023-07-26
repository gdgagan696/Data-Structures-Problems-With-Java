package dsquestions.arrays;

public class MinSpeedTime {
    private static double timeRequired(int[] dist, int speed) {
        double time = 0.0;
        for (int i = 0; i < dist.length; i++) {
            double t = (double) dist[i] / (double) speed;
            time += (i == dist.length - 1 ? t : Math.ceil(t));
        }
        return time;
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 10000000;
        ;
        int minSpeed = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (timeRequired(dist, mid) <= hour) {
                minSpeed = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minSpeed;
    }

    public static void main(String[] args) {
        int[] dist = {1, 3, 2};
        int hour = 6;
        System.out.println(minSpeedOnTime(dist, hour));
    }
}
