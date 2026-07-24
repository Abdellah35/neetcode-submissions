class Solution {
    public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(cache[i], -1);
        }
        return dfs(0, amount, coins, cache);
    }

    private int dfs(int i, int amount, int[] coins,int[][] cache) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length || amount < 0) {
            return 0;
        } if (cache[i][amount] != -1) {
            return cache[i][amount];
        }
        cache[i][amount] = dfs(i + 1, amount, coins, cache) + dfs(i, amount - coins[i], coins, cache);
        return cache[i][amount];
    }
}
