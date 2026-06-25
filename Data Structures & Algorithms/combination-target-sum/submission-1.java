class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combs = new ArrayList<>();
        dfs(0, target, new ArrayList<>(), combs, nums);
        return combs;
    }

    private void dfs(int i, int target, List<Integer> comb, List<List<Integer>> combs, int[] nums) {
        if (target == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        if (i >= nums.length || target <= 0) {
            return;
        }
        comb.add(nums[i]);
        dfs(i, target - nums[i], comb, combs, nums);

        comb.remove(comb.size() - 1);
        dfs(i + 1, target, comb, combs, nums);
    }
}
