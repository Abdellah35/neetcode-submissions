class Solution {
    public boolean canJump(int[] nums) {
        int energy = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            energy = Math.max(energy - 1, nums[i]);
            if (energy <= 0) {
                return false;
            }
        }

        return true;
    }
}
