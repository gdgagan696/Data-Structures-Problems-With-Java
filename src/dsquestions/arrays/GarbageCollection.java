package dsquestions.arrays;

public class GarbageCollection {

    public static int garbageCollection(String[] garbage, int[] travel) {

        int metalIndex = -1;
        int glassIndex = -1;
        int paperIndex = -1;
        int total = 0;
        int[] arr = new int[travel.length];
        arr[0] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            arr[i] = arr[i - 1] + travel[i];
        }
        for (int i = 0; i < garbage.length; i++) {
            String str = garbage[i];
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'M') {
                    metalIndex = i;
                }
                if (str.charAt(j) == 'G') {
                    glassIndex = i;
                }
                if (str.charAt(j) == 'P') {
                    paperIndex = i;
                }
            }
            total += str.length();
        }
        if (metalIndex > 0) {
            total += arr[metalIndex - 1];
        }
        if (glassIndex > 0) {
            total += arr[glassIndex - 1];
        }
        if (paperIndex > 0) {
            total += arr[paperIndex - 1];
        }
        return total;
    }

    public static void main(String[] args) {

        String[] garbage = {"G", "P", "GP", "GG"};
        int[] travel = {2, 4, 3};
        System.out.println(garbageCollection(garbage, travel));

    }

}
