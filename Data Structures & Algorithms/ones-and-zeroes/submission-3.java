class Solution {
    Map<String, Integer> cache;
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] cap = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int size = strs[i].length(), zeros = 0;
            for (char c: strs[i].toCharArray()) {
                if (c == '0') zeros++;
            }
            cap[i] = new int[]{zeros, size - zeros};
        }

        cache = new HashMap<>();
        return backtrack(0, m, n, cap);
    }

    private int backtrack(int i, int m, int n, int[][] cap) {
        String key = i + "," + m + "," + n;
        if (i == cap.length) return 0;
        if (cache.containsKey(key)) return cache.get(key);
        int[] cur = cap[i];
        cache.put(key, backtrack(i + 1, m, n, cap));
        if (m >= cur[0] && n >= cur[1]) {
            cache.put(key, Math.max(cache.get(key),1 + backtrack(i + 1, m - cur[0], n - cur[1], cap)));
        } 
        
        return cache.get(key);
    }
}