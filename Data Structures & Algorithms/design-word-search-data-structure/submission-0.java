class TrieNode {
    boolean word;
    TrieNode[] children;
    TrieNode() {
        word = false;
        children = new TrieNode[26];
    }
}
class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }

        curr.word = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String word, int j, TrieNode root) {
        TrieNode curr = root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child: curr.children) {
                    if (child != null && helper(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }

                curr = curr.children[c - 'a'];
            }
        }

        return curr.word;
    }
}
