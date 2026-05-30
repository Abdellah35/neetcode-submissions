class Solution {
    public int lastStoneWeight(int[] stones) {
    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (int stone: stones) {
            heap.offer(-stone);
        }
        while (heap.size() > 1) {
            int y = -heap.poll();
            int x = -heap.poll();
            if (x < y) {
                heap.offer(- (y-x));
            }
        }
        return heap.size() > 0 ? -heap.poll() : 0;
    }
}
