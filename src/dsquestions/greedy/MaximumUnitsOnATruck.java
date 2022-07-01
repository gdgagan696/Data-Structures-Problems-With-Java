package dsquestions.greedy;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        int total = 0;
        int i = 0;
        while (truckSize > 0 && i < boxTypes.length) {
            if (truckSize >= boxTypes[i][0]) {
                total += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                total += truckSize * boxTypes[i][1];
                truckSize = 0;
            }
            i++;
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }
}
