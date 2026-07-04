class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[58];
        Set<Character> set = new HashSet<>();
        for (char ch: t.toCharArray()) {
            count[ch - 'A']++;
            set.add(ch);
        }
        int[] window = new int[58];
        int[] res = {0, Integer.MAX_VALUE};
        int l = 0;
        int satisfiedCount = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            if (set.contains(ch)) {
                window[ch - 'A']++;
                if (window[ch - 'A'] == count[ch - 'A']) {
                    satisfiedCount++;
                }
                while (satisfiedCount == set.size() && l <= r) {
                    if (res[1] - res[0] > (r - l)) {
                        res = new int[]{l, r};
                    }
                    char lc = s.charAt(l);
                    if (set.contains(lc)) {
                        if (window[lc - 'A'] == count[lc - 'A']) {
                            satisfiedCount--;
                        }
                        window[lc - 'A']--;
                    }
                    l++;
                }
            }
        }
        return res[1] == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
