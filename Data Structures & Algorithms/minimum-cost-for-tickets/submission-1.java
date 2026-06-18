class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Map<Integer, Integer> c = new HashMap<>();
        c.put(1, costs[0]);
        c.put(7, costs[1]);
        c.put(30, costs[2]);
        int[] cache = new int[days.length];
        Arrays.fill(cache, -1);
        return dfs(0, days, costs, c, cache);
    }

    private int dfs(int i, int[] days, int[] costs, Map<Integer, Integer> c, int[] cache) {
        if (i == days.length) return 0;
        if (cache[i] != -1) return cache[i];

        cache[i] = Integer.MAX_VALUE;
        for (var cost: c.entrySet()) {
            int j = i;
            while (j < days.length && days[j] < days[i] + cost.getKey()) {
                j++;
            }
            cache[i] = Math.min(cache[i], cost.getValue() + dfs(j, days, costs, c, cache));
        }

        return cache[i];
    }
}