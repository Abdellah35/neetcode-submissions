class Node {
    int sum;
    Node left;
    Node right;
    int L;
    int R;

    public Node(int total, int L, int R) {
        this.sum = total;
        this.left = null;
        this.right = null;
        this.L = L;
        this.R = R;
    }
}
class SegmentTree {
    Node root;

    public SegmentTree(int[] nums) {
        this.root = build(nums, 0, nums.length - 1);
    }

    private Node build(int[] nums, int L, int R) {
        if (L == R) {
            return new Node(nums[L], L, R);
        }

        int m = (R + L) / 2;
        Node cur = new Node(0, L, R);
        cur.left = build(nums, L, m);
        cur.right = build(nums, m + 1, R);
        cur.sum = cur.left.sum + cur.right.sum;

        return cur;
    }

    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

    public void updateHelper(Node node, int index, int val) {
        if (node.L == node.R) {
            node.sum = val;
            return;
        }

        int m = (node.L + node.R) / 2;
        if (index > m) {
            updateHelper(node.right, index, val);
        } else {
            updateHelper(node.left, index, val);
        }
        node.sum = node.right.sum + node.left.sum;
    }

    public int query(int L, int R) {
        return queryHelper(root, L, R);
    }

    private int queryHelper(Node node, int L, int R) {
        if (node.L == L && node.R == R) {
            return node.sum;
        }

        int M = (node.R + node.L) / 2;
        if (L > M) {
            return queryHelper(node.right, L, R);
        } else if (R <= M) {
            return queryHelper(node.left, L, R);
        } else {
            return (queryHelper(node.left, L, M) + queryHelper(node.right, M + 1, R));
        }
    }
}
