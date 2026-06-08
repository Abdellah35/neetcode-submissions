class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        helper(0, new ArrayList<>(), combs, n, k);
        return combs;
    }

    private void helper(int i, List<Integer> curComb, List<List<Integer>> combs, int n, int k) {
        if (curComb.size() == k) {
            combs.add(new ArrayList<>(curComb));
            return;
        }
        if (i > n) {
            return;
        }

        for (int j = i + 1; j < n + 1; j++) {
            curComb.add(j);
            helper(j, curComb, combs, n, k);
            curComb.remove(curComb.size() - 1);
        }
    }
}