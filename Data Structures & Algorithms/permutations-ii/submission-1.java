class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backtrack(List<Integer> perm, int[] nums, boolean[] pick) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (pick[i] || (i > 0 && nums[i - 1] == nums[i] && !pick[i - 1])) continue;
            perm.add(nums[i]);
            pick[i] = true;

            backtrack(perm, nums, pick);

            perm.remove(perm.size() - 1);
            pick[i] = false;
        }
    }
}