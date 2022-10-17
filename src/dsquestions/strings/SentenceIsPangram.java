package dsquestions.strings;

public class SentenceIsPangram {
    public static boolean checkIfPangram(String sentence) {

        int count[] = new int[26];
        int totalChar = 0;
        for (char ch : sentence.toCharArray()) {
            if (count[ch - 'a'] == 0) {
                totalChar++;
            }
            count[ch - 'a']++;
        }
        return totalChar == 26;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
        System.out.println(checkIfPangram("leetcode"));
    }
}
