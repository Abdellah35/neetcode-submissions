class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] max = {0, 0};
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 & r < n &&  s.charAt(l) == s.charAt(r)) {
                if (max[1] - max[0] < r - l) {
                    max = new int[]{l, r};
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 & r < n &&  s.charAt(l) == s.charAt(r)) {
                if (max[1] - max[0] < r - l) {
                    max = new int[]{l, r};
                }
                l--;
                r++;
            }
        }

        return s.substring(max[0], max[1] + 1);
    }
}
