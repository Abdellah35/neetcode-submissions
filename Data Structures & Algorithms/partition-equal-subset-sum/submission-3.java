class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) {
            return false;
        }
        int target = total / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for (int i = nums.length - 1; i > -1; i--) {
            Set<Integer> newSet = new HashSet<>();
            for (int t: dp) {
                if (t + nums[i] == target) {
                    return true;
                }
                newSet.add(t + nums[i]);
                newSet.add(t);
            }
            dp = newSet;
        }

        return false;
    }
}
