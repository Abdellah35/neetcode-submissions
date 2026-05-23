class Node {
    int sum;
    Node left;
    Node right;
    int L;
    int R;

    Node(int total, int L, int R) {
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

        Node cur = new Node(0, L, R);
        int M = (R + L) / 2;
        cur.left = build(nums, L, M);
        cur.right = build(nums, M + 1, R);
        cur.sum = cur.left.sum + cur.right.sum;
        return cur;
    }

    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

    private void updateHelper(Node root, int index, int val) {
        if (root.L == root.R) {
            root.sum = val;
            return;
        }

        int M = (root.R + root.L) / 2;
        if (index > M) {
            updateHelper(root.right, index, val);
        } else {
            updateHelper(root.left, index, val);
        }

        root.sum = root.left.sum + root.right.sum;
    }

    public int query(int L, int R) {
        return queryHelper(root, L, R);
    }

    private int queryHelper(Node root, int L, int R) {
        if (L == root.L && R == root.R) {
            return root.sum;
        }

        int M = (root.L + root.R) / 2;
        if (L > M) {
            return queryHelper(root.right, L, R);
        } else if (R <= M) {
            return queryHelper(root.left, L, R);
        } else {
            return queryHelper(root.left, L, M) + queryHelper(root.right, M + 1, R);
        }
    }
}
