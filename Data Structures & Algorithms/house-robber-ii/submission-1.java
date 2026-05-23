class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0], Math.max(
            helper(Arrays.copyOfRange(nums, 1, nums.length)),
            helper(Arrays.copyOfRange(nums, 0, nums.length - 1))
        ));
    }

    private int helper(int[] nums) {
        int[] dp = new int[]{0, 0};
        for (int num: nums) {
            int tmp = dp[1];
            dp[1] = Math.max(dp[0] + num, tmp);
            dp[0] = tmp;
        }

        return dp[1];
    }
}
