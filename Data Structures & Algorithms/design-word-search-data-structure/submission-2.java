class TrieNode {
    Map<Character, TrieNode> children;
    boolean word;

    TrieNode() {
        this.children = new HashMap<>();
        this.word = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.word = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String word, int j, TrieNode root) {
        TrieNode cur = root;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (var child: cur.children.entrySet()) {
                    if (child.getValue() != null && helper(word, i + 1, child.getValue())) {
                        return true;
                    }
                }

                return false;
            } else {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
        }
        return cur.word;
    }
}
