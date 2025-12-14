package dsquestions.stacks;

import java.util.ArrayList;
import java.util.List;

public class BuildArray {

    public static List<String> buildArray(int[] target, int n) {

        List<String> res = new ArrayList<>();
        int currentNum = 1;
        int index = 0;
        int lastNum = 0;
        while (currentNum <= n) {
            if (index == target.length) {
                break;
            }
            if (target[index] == currentNum) {
                while (lastNum > 0 && (index == 0 || lastNum != target[index - 1])) {
                    lastNum--;
                    res.add("Pop");
                }
                index++;
            }
            lastNum = currentNum;
            currentNum++;
            res.add("Push");
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(buildArray(new int[]{2, 3, 4}, 4));
    }

}
