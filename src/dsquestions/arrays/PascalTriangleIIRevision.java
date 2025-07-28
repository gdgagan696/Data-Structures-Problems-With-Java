package dsquestions.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleIIRevision {

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int j = 1; j < i; j++) {
                current.add(prev.get(j) + prev.get(j - 1));
            }
            current.add(1);
            prev = current;
        }
        return prev;

    }

    public static void main(String[] args) {

        System.out.println((getRow(3)));
    }

}
