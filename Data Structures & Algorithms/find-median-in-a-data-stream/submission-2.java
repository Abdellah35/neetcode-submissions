class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.add(num);
        if (!small.isEmpty() && !large.isEmpty() && (small.peek() > large.peek())) {
            int val = small.poll();
            large.add(val);
        }

        if (small.size() > large.size() + 1) {
            int val = small.poll();
            large.add(val);
        } else if (large.size()> small.size() + 1) {
            int val = large.poll();
            small.add(val);
        }
    }
    
    public double findMedian() {
        if (small.size() > large.size()) {
            return (double) small.peek();
        } else if (large.size() > small.size()) {
            return (double) large.peek();
        }
        return (double) (small.peek() + large.peek()) / 2;
    }
}
