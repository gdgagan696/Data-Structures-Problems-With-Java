package dsquestions.strings;

public class TruncateString {

    public static String truncateSentence(String s, int k) {

        String[] arr = s.split("\\s+");
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < k) {
            builder.append(arr[i++]).append(" ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {

        String s = "Hello how are you Contestant";
        System.out.println(truncateSentence(s, 4));
    }

}
