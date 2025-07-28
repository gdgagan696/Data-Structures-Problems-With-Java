package dsquestions.arrays;

public class DigitGame {

    public static boolean canAliceWin(int[] nums) {

        int s1 = 0;
        int s2 = 0;
        for (int x : nums) {
            if (x < 10) {
                s1+=x;
            } else {
                s2+=x;
            }
        }
        return s1 != s2;

    }

    public static void main(String[] args) {

        System.out.println(canAliceWin(new int[]{1,2,3,4,10}));
    }


}
