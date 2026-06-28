class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = Integer.MIN_VALUE;
        int globalMax = Integer.MIN_VALUE;
        for (int num: nums) {
            curMax = Math.max(curMax, 0);
            curMax += num;
            globalMax = Math.max(globalMax, curMax);
        }

        return globalMax;
    }
}
