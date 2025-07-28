package dsquestions.tries;

import java.util.*;

public class WordBreakII {

    public static void wordBreakUtil(String s, int i, Set<String> dictionary, List<String> current,List<String>result) {
        if (i == s.length()) {
            result.add(String.join(" ", current));
            return;
        }
        for (int end = i; end < s.length(); end++) {
            String sub = s.substring(i, end+1);
            if (dictionary.contains(sub)) {
                current.add(sub);
                wordBreakUtil(s, end + 1, dictionary, current,result);
                current.remove(current.size() - 1);
            }
        }
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        List<String> current = new ArrayList<>();
        List<String> result = new ArrayList<>();
        wordBreakUtil(s, 0, dictionary, current, result);
        return result;



    }

    public static void main(String[] args) {

        System.out.println(wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}
