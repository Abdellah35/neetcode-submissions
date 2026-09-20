class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> numSet = new HashSet<>();
        int L = 0;
        
        for (int R = 0; R < nums.length; R++) {
            if (R - L > k) {
                numSet.remove(nums[L]);
                L++;
            }

            if (numSet.contains(nums[R])) {
                return true;
            }

            numSet.add(nums[R]);
        }

        return false;
    }
}