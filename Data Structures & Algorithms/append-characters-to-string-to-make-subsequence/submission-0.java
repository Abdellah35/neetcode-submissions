class Solution {
    public int appendCharacters(String s, String t) {
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(r)) {
                r++;
                if (r == t.length()) {
                    break;
                };
            }
        }

        return (t.length()) - r;
    }
}