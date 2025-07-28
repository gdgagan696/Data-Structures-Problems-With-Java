package dsquestions.strings;

public class RobotOrigin {

    public static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') {
                x -= 1;

            } else if (ch == 'R') {
                x += 1;
            } else if (ch == 'U') {
                y += 1;

            } else {
                y -= 1;
            }
        }

        return x == 0 && y == 0;

    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("RRUULLDD"));
    }
}
