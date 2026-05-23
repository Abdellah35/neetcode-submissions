class KthLargest {
    List<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        heap = new ArrayList<>();
        heap.add(Integer.MIN_VALUE);
        this.k = k;

        for (int num: nums) {
            this.insert(num);
            if (heap.size() - 1 > k) {
                this.pop();
            }
        }
    }
    
    public int add(int val) {
        this.insert(val);
        if (heap.size() - 1 > k) {
            this.pop();
        }
        return heap.get(1);
    }

    private void insert(int val) {
        heap.add(val);
        int i = heap.size() - 1;

        while (i > 0 && heap.get(i) < heap.get(i / 2)) {
            int tmp = heap.get(i);
            heap.set(i, heap.get( i / 2));
            heap.set(i / 2, tmp);
            i = i / 2;
        }
    }

    private void pop() {
        if (heap.size() == 1) return;
        if (heap.size() == 2) {
            heap.remove(1);
            return;
        }
        int last = heap.remove(heap.size() - 1);
        heap.set(1, last);
        int i = 1;
        while (i*2 < heap.size()) {
            int left = i * 2, right = i * 2 + 1;
            if (right < heap.size() && heap.get(right) < heap.get(left) && heap.get(right) < heap.get(i)) {
                int tmp = heap.get(right);
                heap.set(right, heap.get(i));
                heap.set(i, tmp);
                i = right;
            } else if (heap.get(left) < heap.get(i)) {
                int tmp = heap.get(left);
                heap.set(left, heap.get(i));
                heap.set(i, tmp);
                i = left;
            } else {
                break;
            }
        }
    }
}