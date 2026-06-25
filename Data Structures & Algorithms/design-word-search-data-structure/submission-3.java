class WordDictionary {
    TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode cur = root;
        for (char c: word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TreeNode());
            }
            cur = cur.children.get(c);
        }
        cur.word = true;
    }

    public boolean search(String word) {
        TreeNode cur = root;
        return dfs(0, word, cur);
    }

    private boolean dfs(int i, String word, TreeNode node) {
        for (int j = i; j < word.length(); j++) {
            char c = word.charAt(j);
            if (c == '.') {
                for (var child: node.children.entrySet()) {
                    if (dfs(j + 1, word, child.getValue())) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
        }

        return node.word;
    }
}

class TreeNode {
    Map<Character, TreeNode> children;
    boolean word;

    public TreeNode() {
        children = new HashMap<>();
        word = false;
    }
}
