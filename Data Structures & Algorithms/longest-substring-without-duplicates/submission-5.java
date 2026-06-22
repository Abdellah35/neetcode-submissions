class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        Set<Character> unique = new HashSet<>();
        int l = 0, r = 0, longest = 0;
        while (r < n) {
            while (l < r && unique.contains(s.charAt(r))) {
                unique.remove(s.charAt(l++));
            }
            unique.add(s.charAt(r));
            longest = Math.max(longest, r - l + 1);
            r++;
        }

        return longest;
    }
}
