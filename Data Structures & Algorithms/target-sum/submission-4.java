class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, nums, 0, target);
    }

    private int dfs(int i, int[] nums, int total, int target) {
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }

        return dfs(i + 1, nums, total + nums[i], target) + dfs(i + 1, nums, total - nums[i], target);
    }
}
