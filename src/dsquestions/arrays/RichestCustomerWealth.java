package dsquestions.arrays;

public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {

        int maxWealth = Integer.MIN_VALUE;
        for (int[] arr : accounts) {
            int currentCustomerWealth = 0;
            for (int x : arr) {
                currentCustomerWealth += x;
            }
            maxWealth = Math.max(maxWealth, currentCustomerWealth);
        }
        return maxWealth;
    }

    public static void main(String[] args) {
        int[][] accounts = {
                {1, 2, 3}, {3, 2, 1}
        };
        System.out.println(maximumWealth(accounts));
    }
}
