class Solution {
    public int climbStairs(int n) {
        return memo(n, new HashMap<>());
    }

    private int memo(int n, Map<Integer, Integer> cache) {
        if (n <= 2) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        cache.put(n, memo(n - 1, cache) + memo(n - 2, cache));
        return cache.get(n);
    }
}
