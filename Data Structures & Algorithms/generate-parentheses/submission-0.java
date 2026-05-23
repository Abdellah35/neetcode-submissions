class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(0, 0, n, res, sb);
        return res;
    }

    private void backtrack(int openN, int closeN, int n, List<String> res, StringBuilder sb) {
        if (openN == closeN && openN == n) {
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            sb.append('(');
            backtrack(openN + 1, closeN, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (closeN < openN) {
            sb.append(')');
            backtrack(openN, closeN + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
