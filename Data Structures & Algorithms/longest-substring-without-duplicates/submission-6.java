class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int L = 0, length = 0;

        for (int R = 0; R < s.length(); R++) {
            char ch = s.charAt(R);
            while (charSet.contains(ch)) {
                charSet.remove(s.charAt(L++));
            }
            charSet.add(ch);
            length = Math.max(length, R - L + 1);
        }

        return length;
    }
}
