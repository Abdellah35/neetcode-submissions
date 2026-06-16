class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        Set<Integer> comb = new HashSet<>();
        comb.add(0);
        for (int i = nums.length - 1; i > -1; i--) {
            Set<Integer> newSet = new HashSet<>();
            for (int n: comb) {
                int sm = n + nums[i];
                if (sm == target) return true;
                newSet.add(sm);
                newSet.add(n);
            }
            comb = newSet;
        }

        return comb.contains(target);
    }
}
