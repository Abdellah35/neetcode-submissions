class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        dfs(0, 0, n, new StringBuilder(), res);
        return res;
    }

    private void dfs(int open, int close, int n, StringBuilder sb, List<String> res) {
        if (open == close && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            dfs(open + 1, close, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            dfs(open, close + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
