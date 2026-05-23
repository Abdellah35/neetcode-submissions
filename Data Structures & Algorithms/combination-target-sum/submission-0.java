class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        dfs(nums, 0, comb, 0, target, res);

        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> comb, int total, int target, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(comb));
            return;
        }

        if (i >= nums.length || total > target) {
            return;
        }

        comb.add(nums[i]);
        dfs(nums, i, comb, total + nums[i], target, res);

        comb.remove(comb.size() - 1);
        dfs(nums, i + 1, comb, total, target, res);
    }
}
