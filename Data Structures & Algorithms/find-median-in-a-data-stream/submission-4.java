class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        minHeap.offer(num);
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }

        while (maxHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
            int tmp = maxHeap.poll();
            maxHeap.offer(minHeap.poll());
            minHeap.offer(tmp);
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
