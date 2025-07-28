package dsquestions;

public class StreamChecker {

	class Trie {
		Trie[] children = new Trie[26];
		boolean isEnd = false;
	}

	Trie root;

	StringBuilder searchedString;

	public StreamChecker(String[] words) {
		root = new Trie();
		for (int i = 0; i < words.length; i++) {
			insert(new StringBuilder(words[i]).reverse().toString());
		}

		searchedString = new StringBuilder();
	}

	private void insert(String word) {
		Trie node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new Trie();
			}
			node = node.children[c - 'a'];
		}
		node.isEnd = true;
	}

	private boolean search(String word) {
		Trie node = root;
		for (int i = word.length() - 1; i >= 0; i--) {
			char c = word.charAt(i);
			if (node.children[c - 'a'] == null)
				return false;
			node = node.children[c - 'a'];
			if (node.isEnd)
				return true;
		}
		return node.isEnd;
	}

	public boolean query(char letter) {
		searchedString.append(letter);
		String string = searchedString.toString();
		return search(string);
	}

	public static void main(String args[]) {
		StreamChecker streamChecker = new StreamChecker(new String[] { "cd", "f", "kl" });
		System.out.println(streamChecker.query('a'));
		System.out.println(streamChecker.query('b'));
		System.out.println(streamChecker.query('c'));
		System.out.println(streamChecker.query('d'));
		System.out.println(streamChecker.query('e'));
		System.out.println(streamChecker.query('f'));
		System.out.println(streamChecker.query('g'));
		System.out.println(streamChecker.query('h'));
		System.out.println(streamChecker.query('i'));
		System.out.println(streamChecker.query('j'));
		System.out.println(streamChecker.query('k'));
		System.out.println(streamChecker.query('l'));

	}

}
