class TrieNode {
    Map<Character, TrieNode> children;
    boolean word;

    TrieNode() {
        this.children = new HashMap<>();
        this.word = false;
    }
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }

        return cur.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char c: prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
