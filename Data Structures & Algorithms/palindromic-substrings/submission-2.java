class Solution {
    public int countSubstrings(String s) {
        int longest = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                longest++;
                r++;
                l--;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                longest++;
                r++;
                l--;
            }
        }

        return longest;
    }
}
