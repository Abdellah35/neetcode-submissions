class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(0, nums, target, 0);
    }

    private int dfs(int i, int[] nums, int target, int total) {
        if (i == nums.length && total == target) return 1;
        if (i >= nums.length) return 0;
        int count = dfs(i + 1, nums, target, total + nums[i]) + dfs(i + 1, nums, target, total - nums[i]);
        return count;
    }
}
