class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMin = 0, curMax = 0, globalMin = nums[0], globalMax = nums[0], total = 0;
        for (int num: nums) {
            curMin = Math.min(num, num + curMin);
            curMax = Math.max(num, num + curMax);
            globalMin = Math.min(curMin, globalMin);
            globalMax = Math.max(globalMax, curMax);
            total += num;
        }

        return globalMax < 0 ? globalMax : Math.max(globalMax, total - globalMin);
    }
}