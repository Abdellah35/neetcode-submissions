class Solution {
    int[][] cache;
    public int maximumProfit(List<Integer> profit, List<Integer> weight, int capacity) {
        cache = new int[profit.size()][capacity + 1];
        for (int i = 0; i < profit.size(); i++) {
            Arrays.fill(cache[i], -1);
        }
        return backtrack(0, profit, weight, capacity);
    }

    private int backtrack(int i, List<Integer> profit, List<Integer> weight, int capacity) {
        if (i == profit.size()) return 0;
        if (cache[i][capacity] != -1) return cache[i][capacity];

        cache[i][capacity] = backtrack(i + 1, profit, weight, capacity);

        if (capacity >= weight.get(i)) {
            int include = profit.get(i) + backtrack(i, profit, weight, capacity - weight.get(i));
            cache[i][capacity] = Math.max(cache[i][capacity], include);
        }

        return cache[i][capacity];
    }
}
