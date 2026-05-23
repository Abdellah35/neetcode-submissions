class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMin = nums[0], globalMax = nums[0];
        int curMax = 0, curMin = 0, total = 0;

        for (int num: nums) {
            curMax = Math.max(curMax + num, num);
            curMin = Math.min(curMin + num, num);
            total += num;
            globalMax = Math.max(globalMax, curMax);
            globalMin = Math.min(globalMin, curMin);
        }

        return globalMax > 0 ? Math.max(globalMax, total - globalMin) : globalMax;
    }
}