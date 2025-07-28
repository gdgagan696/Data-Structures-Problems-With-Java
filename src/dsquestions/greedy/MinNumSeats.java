package dsquestions.greedy;

import java.util.Arrays;

public class MinNumSeats {
    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int minMoves=0;
        for (int i=0;i<seats.length;i++){
            minMoves+=Math.abs(students[i]-seats[i]);
        }
        return minMoves;
    }

    public static void main(String[] args) {
        int []seats = {4,1,5,9};
        int []students = {1,3,2,6};
        System.out.println(minMovesToSeat(seats,students));
    }
}
