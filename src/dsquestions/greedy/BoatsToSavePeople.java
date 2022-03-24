package dsquestions.greedy;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        int boatsNeeded = 0;
        while (i <= j) {
            int total = people[i] + people[j];
            if (total <= limit) {
                boatsNeeded++;
                i++;
                j--;
            } else {
                j--;
                boatsNeeded++;
            }
        }

        return boatsNeeded;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }
}
