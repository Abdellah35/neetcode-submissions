class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void push(int val) {
        heap.add(val);
        bubleUp(heap.size() - 1);
    }

    public Integer pop() {
        if (heap.size() <= 1) {
            return -1;
        }
        if (heap.size() == 2) {
            return heap.remove(1);
        }

        int root = heap.get(1);
        heap.set(1, heap.remove(heap.size() - 1));
        if (heap.size() > 1) {
            bubleDown(1);
        }
        return root;

    }

    public Integer top() {
        return heap.size() > 1 ? heap.get(1) : -1;
    }

    public void heapify(List<Integer> nums) {
        heap = new ArrayList<>();
        heap.add(0);
        heap.addAll(nums);

        for (int i = heap.size() / 2; i >= 1; i-- ) {
            bubleDown(i);
        }

    }

    private void bubleUp(int index) {
        int parent = index / 2;

        while (index > 1 && heap.get(index) < heap.get(parent)) {
            int temp = heap.get(index);
            heap.set(index, heap.get(parent));
            heap.set(parent, temp);
            index = parent;
            parent = index / 2;
        }
    }

    private void bubleDown(int index) {
        int child = index * 2;

        while (child < heap.size()) {
            if (child + 1 < heap.size() && heap.get(child + 1) < heap.get(child)) {
                child++;
            }

            if (heap.get(child) >= heap.get(index)) {
                break;
            }

            int temp = heap.get(child);
            heap.set(child, heap.get(index));
            heap.set(index, temp);
            index = child;
            child = 2 * index;
        }
    }


}
