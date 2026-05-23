class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxReach < i) {
                return false;
            } else if (maxReach >= nums.length - 1) {
                return true;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return maxReach >= nums.length - 1;
    }
}
