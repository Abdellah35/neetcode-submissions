class Tree {
    Tree left;
    Tree right;
    int start;
    int end;

    public Tree(int s, int e) {
        this.left = null;
        this.right = null;
        this.start = s;
        this.end = e;
    }

    public boolean insert(int s, int e) {
        Tree cur = this;
        while (true) {
            if (s >= cur.end) {
                if (cur.right == null) {
                    cur.right = new Tree(s, e);
                    return true;
                }
                cur = cur.right;
            } else if (e <= cur.start) {
                if (cur.left == null) {
                    cur.left = new Tree(s, e);
                    return true;
                }
                cur = cur.left;
            } else {
                return false;
            }
        }
    }
}

class MyCalendar {
    Tree root;
    public MyCalendar() {
        root = null;
    }
    
    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Tree(startTime, endTime);
            return true;
        }

        return this.root.insert(startTime, endTime);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */