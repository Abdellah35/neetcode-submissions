class Solution {
    public int maxProduct(int[] nums) {
        int curMax = 1, curMin = 1, globalMax = Integer.MIN_VALUE;
        for (int num: nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(curMax * num, curMin * num), num);
            curMin = Math.min(Math.min(tmp, curMin * num), num);
            globalMax = Math.max(globalMax, curMax);
        }

        return globalMax == Integer.MIN_VALUE ? nums[0] : globalMax;
    }
}
