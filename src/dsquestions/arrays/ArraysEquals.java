package dsquestions.arrays;

import java.util.Arrays;

public class ArraysEquals {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(arr);
        Arrays.sort(target);
        return Arrays.equals(arr,target);

    }
}
