package dsquestions.arrays;

public class MinDeletionToMakeStringBalanced {
    public static int minimumDeletions(String s) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == 'b') {
                    count++;
                }

            }
            for (int k = i + 1; k < s.length(); k++) {
                if (s.charAt(k) == 'a') {
                    count++;
                }
            }
            res = Math.min(res, count);
        }
        return res;
    }

    public static int minimumDeletionsOptimised(String s) {
        int res = Integer.MAX_VALUE;
        int bCount = 0;
        int aCount = 0;
        int[] totalBs = new int[s.length()];
        int[] totalAs = new int[s.length()];
        for (int i = 0; i < totalBs.length; i++) {
            totalBs[i] = bCount;
            if (s.charAt(i) == 'b') {
                bCount++;
            }
        }
        for (int i = totalAs.length - 1; i >= 0; i--) {
            totalAs[i] = aCount;
            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            res = Math.min(res, totalAs[i] + totalBs[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
        System.out.println(minimumDeletionsOptimised("aababbab"));
    }
}
