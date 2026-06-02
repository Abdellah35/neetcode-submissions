class Solution {
    public int subarraySum(int[] nums, int k) {
        int curSum = 0, res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int num: nums) {
            curSum += num;
            int diff = curSum - k;
            res += preSum.getOrDefault(diff, 0);
            preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        }

        return res;
    }
}