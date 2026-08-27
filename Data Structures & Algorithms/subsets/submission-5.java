class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        backtrack(0, new ArrayList<>(), nums, subset);
        return subset;
    }

    private void backtrack(int i, List<Integer> set, int[] nums, List<List<Integer>> subset) {
        if (i == nums.length) {
            subset.add(new ArrayList<>(set));
            return;
        }

        set.add(nums[i]);
        backtrack(i + 1, set, nums, subset);

        set.remove(set.size() - 1);
        backtrack(i + 1, set, nums, subset);
    }
}
