class Solution {
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] cache = new int[profit.size()][capacity + 1];
        for (int i = 0; i < profit.size(); i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(0, profit, weight, capacity, cache);
    }

    private int dfs(int i, List<Integer> profit, List<Integer> weight, int capacity, int[][] cache) {
        if (i == profit.size()) {
            return 0;
        } if (cache[i][capacity] != -1) {
            return cache[i][capacity];
        }

        cache[i][capacity] = dfs(i + 1, profit, weight, capacity, cache);
        int newCapacity = capacity - weight.get(i);
        if (newCapacity >= 0) {
            int p = profit.get(i) + dfs(i + 1, profit, weight, newCapacity, cache);
            cache[i][capacity] = Math.max(cache[i][capacity], p);
        }
        return cache[i][capacity];
    }
}
