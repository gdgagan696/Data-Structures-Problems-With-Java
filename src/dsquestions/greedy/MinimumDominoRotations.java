package dsquestions.greedy;

public class MinimumDominoRotations {
    public static int minDominoRotations(int[] tops, int[] bottoms) {

        int op1 = minDominoRotationsUtil(tops, bottoms, tops[0]);
        int op2 = minDominoRotationsUtil(tops, bottoms, bottoms[0]);
        if (op1 == -1 && op2 == -1) {
            return -1;
        } else if (op1 == -1) {
            return op2;
        } else if (op2 == -1) {
            return op1;
        } else {
            return Math.min(op1, op2);
        }
    }

    private static int minDominoRotationsUtil(int[] tops, int[] bottoms, int num) {
        int topSwap = 0;
        int bottomSwap = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != num && bottoms[i] != num) {
                return -1;
            }
            if (tops[i] != num && bottoms[i] == num) {
                topSwap++;
            }
            if (tops[i] == num && bottoms[i] != num) {
                bottomSwap++;
            }
        }
        return Math.min(topSwap, bottomSwap);
    }

    public static void main(String[] args) {
        int tops[] = {2, 1, 2, 4, 2, 2};
        int bottoms[] = {5, 2, 6, 2, 3, 2};
        System.out.println(minDominoRotations(tops, bottoms));
    }
}
