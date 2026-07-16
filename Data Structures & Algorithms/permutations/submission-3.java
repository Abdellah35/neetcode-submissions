class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return dfs(0, nums);
    }

    private List<List<Integer>> dfs(int i, int[] nums) {
        if (nums.length == i) {
            List<List<Integer>> comb = new ArrayList<>();
            comb.add(new ArrayList<>());
            return comb;
        }

        List<List<Integer>> res = dfs(i + 1, nums);
        List<List<Integer>> combs = new ArrayList<>();
        for (var comb: res) {
            for (int j = 0; j <= comb.size(); j++) {
                List<Integer> pCp = new ArrayList<>(comb);
                pCp.add(j, nums[i]);
                combs.add(pCp);
            }
        }

        return combs;
    }
}
