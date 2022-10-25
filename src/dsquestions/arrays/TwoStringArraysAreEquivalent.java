package dsquestions.arrays;

public class TwoStringArraysAreEquivalent {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
    }
}
