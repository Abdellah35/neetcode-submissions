class Solution {
    public String longestPalindrome(String s) {
        int[] res = {0, 0};
        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > longest) {
                    longest = r - l + 1;
                    res = new int[]{l, r};
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > longest) {
                    longest = r - l + 1;
                    res = new int[]{l, r};
                }
                l--;
                r++;
            }
        }

        return s.substring(res[0], res[1] + 1);
    }
}
