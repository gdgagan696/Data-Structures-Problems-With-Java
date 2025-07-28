package dsquestions.bitwise;

public class CountTriplets {
    public static int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int xor = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                xor = xor ^ arr[j];
                if (xor == 0) {
                    count += j - i;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
    }
}
