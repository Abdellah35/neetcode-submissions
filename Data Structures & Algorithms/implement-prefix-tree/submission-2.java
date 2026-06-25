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
        for (char c: word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.word;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for (char c: prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }

        return true;
    }
}
