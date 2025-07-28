package dsquestions.tries;

public class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                temp.children[ch - 'a'] = new TrieNode();
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isTerminal = true;
    }

    public boolean searchWord(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                return false;
            }
            temp = temp.children[ch - 'a'];
        }
        return temp.isTerminal;
    }
}
