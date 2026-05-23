class Solution {
    public String longestPalindrome(String s) {
        int[] max = new int[2];
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i, r = i; // odd;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > length){
                    length = r - l + 1;
                    max = new int[]{l, r};
                }
                r++;
                l--;
            }

            l = i; r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if ((r - l + 1) > length){
                    length = r - l + 1;
                    max = new int[]{l, r};
                }
                r++;
                l--;
            }

        }

        int l = max[0], r = max[1];
        return s.substring(l, r + 1);
    }
}
