class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;
        int half = total / 2;
        Boolean[][] cache = new Boolean[nums.length][half + 1];
        return dfs(0, half, nums, cache);
    }

    private boolean dfs(int i, int target, int[] nums, Boolean[][] cache) {
        if (i == nums.length || target < 0) {
            return target == 0;
        } 
        if (cache[i][target] != null) {
            return cache[i][target];
        }
        

        cache[i][target] = dfs(i + 1, target, nums, cache) || dfs(i + 1, target - nums[i], nums, cache);
        return cache[i][target];
    }
}
