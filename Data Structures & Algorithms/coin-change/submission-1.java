class Solution {
    int[][] cache;
    public int coinChange(int[] coins, int amount) {
        cache = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(cache[i], -2);
        }

        return backtrack(0, amount, coins);
    }

    private int backtrack(int i, int amount, int[] coins) {
        if (amount == 0) return 0;
        if (i == coins.length || amount < 0) return -1;
        if (cache[i][amount] != -2) return cache[i][amount];
        cache[i][amount] = backtrack(i + 1, amount, coins);

        if (amount >= coins[i]) {
            int include = backtrack(i, amount - coins[i], coins);
            if (include != -1) {
                if (cache[i][amount] == -1) {
                    cache[i][amount] = include + 1;
                } else {
                    cache[i][amount] = Math.min(cache[i][amount], include + 1);
                }
            }
        }

        return cache[i][amount];
    }
}
