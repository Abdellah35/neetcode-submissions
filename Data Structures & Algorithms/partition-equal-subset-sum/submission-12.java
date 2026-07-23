class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;
        int half = total / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> nextDp = new HashSet<>();
            for (int p: dp) {
                nextDp.add(p + nums[i]);
                nextDp.add(p);
            }
            dp = nextDp;
        }

        return dp.contains(half);
    }
}
