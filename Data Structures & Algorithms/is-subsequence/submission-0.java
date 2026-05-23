class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }

        int l = 0;
        int sl = s.length();
        for (char ch: t.toCharArray()) {
            if (sl > l && ch == s.charAt(l)) {
                l++;
            } else if (sl <= l) {
                return true;
            }
        }

        return l == sl;
    }
}