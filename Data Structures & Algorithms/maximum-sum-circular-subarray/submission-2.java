class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0, globalMax = nums[0];
        int curMin = 0, globalMin = nums[0];
        int total = 0;

        for (int num: nums) {
            curMax = Math.max(curMax, 0);
            curMax += num;
            globalMax = Math.max(globalMax, curMax);

            curMin = Math.min(curMin, 0);
            curMin += num;
            globalMin = Math.min(globalMin, curMin);
            total += num;
        }

        return globalMax < 0 ? globalMax : Math.max(globalMax, total - globalMin);
    }
}