package dsquestions.maths;

public class WaitTime {
    public static double averageWaitingTime(int[][] customers) {
        long time = customers[0][0];
        long wait = 0;
        for (int[] customer : customers) {
            time = Math.max(customer[0], time) + customer[1];
            wait += time - customer[0];
        }
        return (double) wait / customers.length;
    }

    public static void main(String[] args) {
        int[][] customers = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        System.out.println(averageWaitingTime(customers));
    }
}
