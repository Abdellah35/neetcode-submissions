class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> combs = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, combs, target);
        return combs;
    }

    private void backtrack(int i, List<Integer> comb, int[] nums, List<List<Integer>> combs, int target) {
        if (target == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        if (i == nums.length || target < 0) {
            return;
        }

        comb.add(nums[i]);
        backtrack(i, comb, nums, combs, target - nums[i]);

        comb.remove(comb.size() - 1);
        backtrack(i + 1, comb, nums, combs, target);
    }
}
