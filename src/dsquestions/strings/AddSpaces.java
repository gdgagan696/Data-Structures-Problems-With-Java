package dsquestions.strings;

public class AddSpaces {

    public static String addSpaces(String s, int[] spaces) {

        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && i == spaces[j]) {
                sb.append(" ");
                j++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
    }

}
