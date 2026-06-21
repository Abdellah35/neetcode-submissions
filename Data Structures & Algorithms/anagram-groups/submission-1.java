class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            map.putIfAbsent(new String(sorted), new ArrayList<>());
            map.get(new String(sorted)).add(i);
        }

        for (var entry: map.entrySet()) {
            List<String> val = new ArrayList<>();
            for (Integer i: entry.getValue()) {
                val.add(strs[i]);
            }
            res.add(val);
        }

        return res;
    }
}
