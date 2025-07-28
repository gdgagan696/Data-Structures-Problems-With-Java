package dsquestions.maths;

public class PassThePillow {
    public int passThePillow(int n, int time) {
        int pos = 1;
        int dir = 1;
        while (time > 0) {
            pos += dir;
            time--;
            if (pos == n || pos == 1) {
                dir = dir * -1;
            }
        }
        return pos;
    }
}
