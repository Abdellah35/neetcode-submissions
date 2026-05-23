class Solution {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0, 0, s);
        return res;
    }

    private void dfs(int j, int i, String s) {
        if (i >= s.length()) {
            if (i == j) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (isPalin(j, i, s)) {
            path.add(s.substring(j, i + 1));
            dfs(i + 1, i + 1, s);
            path.remove(path.size() - 1);
        }

        dfs(j, i + 1, s);
    }

    private boolean isPalin(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}