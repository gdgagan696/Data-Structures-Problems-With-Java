package dsquestions.backtracking;

public class CountSortedVowels {

    public static int countVowelStrings(int n) {
        char[] vowels = {'a', 'e', 'i', 'o','u'};
        return countVowelStrings(n, vowels, new StringBuilder(""));
    }

    private static int countVowelStrings(int n, char[] vowels, StringBuilder current) {
        if (current.length() == n) {
            return 1;
        }
        int total = 0;
        for (char ch : vowels) {
            if((current.length()>=1 && current.charAt(current.length()-1)<=ch) || current.length()==0) {
                total += countVowelStrings(n, vowels, current.append(ch));
                current.deleteCharAt(current.length() - 1);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(countVowelStrings(2));

    }

}
