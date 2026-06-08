class Solution {
    public List<String> letterCombinations(String digits) {
        String[] digitToChar = {"", "", "abc", "def", "ghi", "jkl","mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (!digits.isEmpty()) {
            helper(0, digits, digitToChar, "", res);
        }
        return res;
    }

    private void helper(int i, String digits, String[] digitToChar, String curStr, List<String> res) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c: chars.toCharArray()) {
            helper(i + 1, digits, digitToChar, curStr + c, res);
        }
    }
}
