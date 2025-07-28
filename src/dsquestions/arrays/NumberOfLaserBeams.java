package dsquestions.arrays;

public class NumberOfLaserBeams {

    public static int numberOfBeams(String[] bank) {

        int temp = 0;
        int res = 0;
        for (String s : bank) {
            int total = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    total++;
                }
            }
            if (total != 0) {
                res += total * temp;
                temp = total;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String[] bank = {"000", "111", "000"};
        System.out.println(numberOfBeams(bank));

    }

}
