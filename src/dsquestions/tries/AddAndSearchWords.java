package dsquestions.tries;

public class AddAndSearchWords {

    TrieNode root;

    public AddAndSearchWords() {
        this.root = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.isTerminal = true;

    }

    public boolean search(String word) {
        return searchUtil(word, root);
    }

    private boolean searchUtil(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode child : node.children)
                    if (child != null && searchUtil(word.substring(i + 1), child)) return true;
                return false;
            } else if (node.children[ch - 'a'] == null) {
                return false;
            }
            node = node.children[ch - 'a'];
        }
        return node != null && node.isTerminal;
    }

    public static void main(String[] args) {
        AddAndSearchWords addAndSearchWords = new AddAndSearchWords();
        addAndSearchWords.addWord("dad");
        System.out.println(addAndSearchWords.search("dad"));
        System.out.println(addAndSearchWords.search("d.d"));
    }
}
