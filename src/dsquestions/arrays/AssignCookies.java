package dsquestions.arrays;

import java.util.Arrays;

public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] g = {1, 2};
        int[] s = {1, 2,3};
        System.out.println(findContentChildren(g, s));

    }
}
