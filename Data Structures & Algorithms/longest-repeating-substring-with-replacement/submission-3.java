class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        
        int L = 0, res = 0;

        for (int R = 0; R < s.length(); R++) {
            char c = s.charAt(R);
            count.put(c, count.getOrDefault(c, 0) + 1);
            int largest = 0;
            for (Map.Entry<Character, Integer> entry: count.entrySet()) {
                largest = Math.max(largest, entry.getValue());
            }

            while ((R - L + 1) - largest > k) {
                char lc = s.charAt(L++);
                count.put(lc, count.get(lc) - 1);
            }

            res = Math.max(res, R - L + 1);
        }

        return res;
    }
}
