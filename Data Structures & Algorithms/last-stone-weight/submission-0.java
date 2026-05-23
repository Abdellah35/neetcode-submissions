class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int stone: stones) {
            heap.offer(-stone);
        }

        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();

            if (y > x) {
                heap.offer(x - y);
            }
        }
        heap.offer(0);

        return Math.abs(heap.peek());
    }
}
