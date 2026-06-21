class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        for (int i = 0; i < nums.length; i++) {
            int l = 1;
            if (!set.contains(nums[i] - 1)) {
                while (set.contains(nums[i] + l)) {
                    l++;
                }
            }
            longest = Math.max(longest, l);
        }

        return longest;
    }
}
