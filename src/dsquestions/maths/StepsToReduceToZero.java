package dsquestions.maths;

public class StepsToReduceToZero {

    public static int numberOfSteps(int num) {

        int steps = 0;
        while (num > 0) {
            steps++;
            num = (num & 1) == 0 ? num / 2 : num - 1;
        }
        return steps;

    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }

}
