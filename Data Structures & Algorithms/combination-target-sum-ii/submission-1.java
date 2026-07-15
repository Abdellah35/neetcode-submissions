class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, target, new ArrayList<>(), candidates, res);
        return res;
    }

    private void dfs(int i, int target, List<Integer> comb, int[] candidates, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        if (i == candidates.length || target < 0) {
            return;
        }
        comb.add(candidates[i]);
        dfs(i + 1, target - candidates[i], comb, candidates, res);
        comb.remove(comb.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(i + 1, target, comb, candidates, res);
    }
}
