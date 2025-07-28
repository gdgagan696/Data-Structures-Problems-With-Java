package dsquestions.greedy;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGasAvailable = 0;
        for (int i = 0; i < cost.length; i++) {
            totalGasAvailable += gas[i];
            totalGasAvailable -= cost[i];
        }
        if (totalGasAvailable < 0) return -1;

        int availableGas = 0;
        int index = 0;
        for (int i = 0; i < cost.length; i++) {
            availableGas += gas[i];
            availableGas -= cost[i];
            if (availableGas < 0) {
                availableGas = 0;
                index = i + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int gas[] = {1, 2, 3, 4, 5};
        int cost[] = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
