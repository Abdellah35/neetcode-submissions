class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = Integer.MIN_VALUE;
        int L = 0;
        Set<Character> window = new HashSet<>();
        for (int R = 0; R < s.length(); R++) {
            while (L < R && window.contains(s.charAt(R))) {
                window.remove(s.charAt(L++));
            }

            window.add(s.charAt(R));
            longest = Math.max(longest, R - L + 1);
        }

        return longest == Integer.MIN_VALUE ? 0 : longest;
    }
}
