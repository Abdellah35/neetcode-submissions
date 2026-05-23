class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(n, k, 1, new ArrayList<>(), res);

        return res;
    }


    private void helper(int n, int k, int i, List<Integer> comb, List<List<Integer>> res) {
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }

        if (i > n) {
            return;
        }

        comb.add(i);
        helper(n, k, i + 1, comb, res);

        comb.remove(comb.size() - 1);
        helper(n, k, i + 1, comb, res);
    }
}