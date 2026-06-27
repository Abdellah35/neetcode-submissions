class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(s.length(), 1);
        return dfs(0, s, memo);
    }

    private int dfs(int i, String s, Map<Integer, Integer> memo) {
        if (memo.containsKey(i)) return memo.get(i);
        if (s.charAt(i) == '0') return 0;
        int res = dfs(i + 1, s, memo);
        if (i + 1 < s.length() && 
        (s.charAt(i) == '1' || (s.charAt(i) == '2' && Integer.parseInt(s.substring(i + 1, i + 2)) < 7))) {
            res += dfs(i + 2, s, memo);
        }
        memo.put(i, res);
        return res;
    }
}
