class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int longest = 0, L = 0, maxc = 0;

        for (int R = 0; R < s.length(); R++) {
            char ch = s.charAt(R);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
            maxc = Math.max(maxc, count.get(ch));
            if ((R - L + 1) - maxc > k) {
                char lc = s.charAt(L++);
                count.put(lc, count.get(lc) - 1);
            }
            longest = Math.max(longest, R - L + 1);
        }

        return longest;
    }
}
