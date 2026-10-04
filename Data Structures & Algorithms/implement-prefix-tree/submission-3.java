class TreeNode {
    Map<Character, TreeNode> children;
    boolean word;

    public TreeNode() {
        children = new HashMap<>();
        word = false;
    }
}

class PrefixTree {
    TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;

        for (char ch: word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TreeNode());
            }
            node = node.children.get(ch);
        }

        node.word = true;
    }

    public boolean search(String word) {
        TreeNode node = root;
        for (char ch: word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.word;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = root;

        for (char ch: prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }

        return true;
    }
}
