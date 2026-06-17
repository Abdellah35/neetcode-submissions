class Solution {
    public int lastStoneWeightII(int[] stones) {
        int stoneSum = Arrays.stream(stones).sum();
        int target = (stoneSum + 1) / 2;
        int[][] cache = new int[stones.length][target];
        for (int i = 0; i < stones.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        return dfs(0, 0, target, stones, stoneSum, cache);
    }

    private int dfs(int i, int total, int target, int[] stones, int stoneSum, int[][] cache) {
        if (total >= target || i == stones.length) {
            return Math.abs(total - (stoneSum - total));
        } if (cache[i][total] != -1) {
            return cache[i][total];
        }

        cache[i][total] = Math.min(dfs(i + 1, total, target, stones, stoneSum, cache),
                        dfs(i + 1, total + stones[i], target, stones, stoneSum, cache));
        return cache[i][total];    
    }
}