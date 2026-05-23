class Solution {
    public String minWindow(String s, String t) {
        if (t == "") return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c: t.toCharArray()) {
            countT.put(c, 1 + countT.getOrDefault(c, 0));
        }

        int have = 0, need = countT.size();
        int[] res = new int[2];
        int resLen = Integer.MAX_VALUE;
        int l = 0;
        
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, 1 + window.getOrDefault(c, 0));

            if (countT.containsKey(c) && countT.get(c) == window.get(c)) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    res = new int[]{l, r};
                    resLen = r - l + 1;
                }
                char lc = s.charAt(l);
                window.put(lc, window.get(lc) - 1);
                if (countT.containsKey(lc) && window.get(lc) < countT.get(lc)) {
                    have--;
                }

                l++;
            }
        }

        int low = res[0], high = res[1];
        return resLen != Integer.MAX_VALUE ? s.substring(low, high + 1) : "";
    }
}
