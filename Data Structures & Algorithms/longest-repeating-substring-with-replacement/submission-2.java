class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        int l = 0, mf = 0;
        Map<Character, Integer> count = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            mf = Math.max(mf, count.get(s.charAt(r)));
            while ((r - l + 1) - mf > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
}
