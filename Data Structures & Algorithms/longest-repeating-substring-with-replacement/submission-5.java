class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0, longest = 0, maxf = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            count.put(c, count.getOrDefault(c, 0) + 1);
            maxf = Math.max(maxf, count.get(c));
            while ((r - l + 1) - maxf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
