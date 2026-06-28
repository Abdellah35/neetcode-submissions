class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> memo = new HashMap<>();
        memo.put(s.length(), true);
        return helper(0, s, wordDict, memo);
    }

    private boolean helper(int i, String s, List<String> wordDict, Map<Integer, Boolean> memo) {
        if (memo.containsKey(i)) return memo.get(i);

        for (String word: wordDict) {
            if (i + word.length() > s.length()) continue;
            if (word.equals(s.substring(i, i + word.length()))) {
                if (helper(i + word.length(), s, wordDict, memo)) {
                    memo.put(i, true);
                    return true;
                }
            }
        }

        memo.put(i, false);
        return false;
    }
}
