class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Cnt = new int[26];
        int[] s2Cnt = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Cnt[s1.charAt(i) - 'a']++;
            s2Cnt[s2.charAt(i) - 'a']++;
        }

        int match = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Cnt[i] == s2Cnt[i]) {
                match++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (match == 26) {
                return true;
            }

            int idx = s2.charAt(r) - 'a';
            s2Cnt[idx]++;
            if (s2Cnt[idx] == s1Cnt[idx]) {
                match++;
            } else if(s2Cnt[idx] - 1 == s1Cnt[idx]) {
                match--;
            }

            idx = s2.charAt(l) - 'a';
            s2Cnt[idx]--;
            if (s2Cnt[idx] == s1Cnt[idx]) {
                match++;
            } else if (s2Cnt[idx] + 1 == s1Cnt[idx]) {
                match--;
            }

            l++;
        }
        return match == 26;
    }
}
