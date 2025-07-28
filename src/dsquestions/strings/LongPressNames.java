package dsquestions.strings;

public class LongPressNames {

    public static boolean isLongPressedName(String name, String typed) {

        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }
        while (j < typed.length() && typed.charAt(j - 1) == typed.charAt(j)) {
            j++;
        }

        return i == name.length() && j == typed.length();
    }


    public static void main(String[] args) {

        System.out.println(isLongPressedName("alex", "aaleelx"));
    }

}
