class Solution {
    private String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
        };
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (!digits.isEmpty()) {
            helper(0, "", digits);
        }
        return res;
    }

    private void helper(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c: chars.toCharArray()) {
            helper(i + 1, curStr + c, digits);
        }

    }
}
