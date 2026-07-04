class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for (char c: s1.toCharArray()) {
            count[c - 'a']++;
        }
        int[] window = new int[26];

        for (int r = 0; r < s2.length(); r++) {
            char ch = s2.charAt(r);
            window[ch - 'a']++;
            if (r >= s1.length()) {
                window[s2.charAt(r - s1.length()) - 'a']--;
            }
            if (Arrays.equals(window, count)) return true;
        } 

        return false;
    }
}
