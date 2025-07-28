package dsquestions.stacks;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArray {
    public static List<String> buildArray(int[] target, int n) {

        List<String> result = new ArrayList<>();
        int i = 0;
        int num = 1;
        while (true) {
            if (i >= target.length) break;
            if (num == target[i]) {
                result.add("Push");
                i++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
            num++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(buildArray(new int[]{2,3,4   },4));

    }
}
