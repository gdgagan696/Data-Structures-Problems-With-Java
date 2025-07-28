package dsquestions.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high) {
        int[] digits = new int[9];
        for (int i = 0; i <= 8; i++) {
            digits[i] = i + 1;
        }
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i <= 7; i++) {
            int current = digits[i];
            for (int j = i + 1; j <= 8; j++) {
                int potential = current * 10 + digits[j];
                if (potential >= low && potential <= high) {
                    results.add(potential);
                }
                if (potential > high) {
                    break;
                }
                current = potential;
            }
        }

        Collections.sort(results);
        return results;
    }

    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));
    }
}
