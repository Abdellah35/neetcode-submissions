class TrieNode {
    Map<Character, TrieNode> children;
    boolean word;

    public TrieNode() {
        children = new HashMap<>();
        word = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        return helper(0, word, node);
    }

    private boolean helper(int i, String word, TrieNode node) {
        for (int j = i; j < word.length(); j++) {
            char ch = word.charAt(j);
            if (ch == '.') {
                for (TrieNode child: node.children.values()) {
                    if (helper(j + 1, word, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!node.children.containsKey(ch)) {
                    return false;
                }
                node = node.children.get(ch);
            }
        }

        return node.word;
    }
}
