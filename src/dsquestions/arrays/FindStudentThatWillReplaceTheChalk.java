package dsquestions.arrays;

public class FindStudentThatWillReplaceTheChalk {

    public static int chalkReplacer(int[] chalk, int k) {

        long sum = 0;
        for (int c : chalk) {
            sum += c;
        }
        k %= sum;
        int i = 0;
        while (chalk[i] <= k) {
            k -= chalk[i];
            i++;
        }
        return i;
    }

    public static void main(String[] args) {

        System.out.println(chalkReplacer(new int[]{5, 1, 5}, 22));
//        System.out.println(chalkReplacer(new int[]{3,4,1,2},25));
    }

}
