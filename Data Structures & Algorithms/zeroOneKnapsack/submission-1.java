class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int M = profit.size(), N = capacity;
        int[][] cache = new int[M][N + 1];
        for (int i = 0; i < M; i++) {
            Arrays.fill(cache[i], -1);
        }

        return memoization(0, profit, weight, capacity, cache);
    }

    private int memoization(int i, List<Integer> profit, List<Integer> weight, int capacity, int[][] cache) {
        if (i >= profit.size() || capacity <= 0) return 0;
        if (cache[i][capacity] != -1) return cache[i][capacity];
        
        cache[i][capacity] = memoization(i + 1, profit, weight, capacity, cache);
        
        int newCap = capacity - weight.get(i);
        
        if (newCap >= 0) {
            int gain = profit.get(i) + memoization(i + 1, profit, weight, newCap, cache);
            cache[i][capacity] = Math.max(gain, cache[i][capacity]);
        }

        return cache[i][capacity];
    }
}
