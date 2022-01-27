package dsquestions.tries;

public class MaxXOROfTwoNums {

    class TrieNode {
        TrieNode children[];

        TrieNode() {
            children = new TrieNode[2];
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }


        public void insertNum(int num) {
            TrieNode current = root;
            for (int i = 31; i >= 0; i--) {

                int currentBit = (num >> i) & 1;
                if (current.children[currentBit] == null) {
                    current.children[currentBit] = new TrieNode();
                }
                current = current.children[currentBit];
            }
        }

        public int findMaxXORs(int num) {
            TrieNode current = root;
            int max = 0;
            for (int i = 31; i >= 0; i--) {

                int currentBit = (num >> i) & 1;
                if (current.children[1 - currentBit] != null) {
                    max = max | 1 << i;
                    current = current.children[1 - currentBit];
                } else {
                    current = current.children[currentBit];
                }
            }
            return max;
        }


    }

    public static void main(String[] args) {

        int[] nums = {3, 10, 5, 25, 2, 8};
        MaxXOROfTwoNums maxXOROfTwoNums = new MaxXOROfTwoNums();
        Trie trie = maxXOROfTwoNums.new Trie();
        for (int x : nums) {
            trie.insertNum(x);
        }
        int maxSum = 0;
        for (int x : nums) {
            maxSum = Math.max(trie.findMaxXORs(x), maxSum);
        }
        System.out.println(maxSum);
    }
}
