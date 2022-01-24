package dsquestions.strings;

public class DetectCaptial {
    public static boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        return isUpperCase(word) || isLowerCase(word) || isCapitcalCase(word);

    }

    private static boolean isUpperCase(String word) {

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLowerCase(String word) {
        for (char ch : word.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCapitcalCase(String word) {
        return isUpperCase(word.substring(0, 1)) && isLowerCase(word.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
    }
}
