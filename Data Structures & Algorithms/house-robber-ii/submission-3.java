class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)),
                helper(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    private int helper(int[] nums) {
        int dp[] = {0, 0};
        for (int num: nums) {
            int tmp = dp[1];
            dp[1] = Math.max(dp[0] + num, tmp);
            dp[0] = tmp;
        }
        return dp[1];
    }
}
