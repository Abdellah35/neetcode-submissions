class Solution {
    public int lengthOfLongestSubstring(String s) {
        int L = 0;
        int length = 0;
        Set<Character> seen = new HashSet<>();

        for (int R = 0; R < s.length(); R++) {
            while (seen.contains(s.charAt(R))) {
                seen.remove(s.charAt(L++));
            }
            seen.add(s.charAt(R));
            length = Math.max(length, R - L + 1);
        }

        return length;
    }
}
