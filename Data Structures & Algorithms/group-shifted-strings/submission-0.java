class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strings) {
            String hash = getHash(str);
            if (map.get(hash) == null) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(str);
        }

        List<List<String>> groups = new ArrayList<>();

        for (var group: map.values()) {
            groups.add(group);
        }

        return groups;
    }

    private String getHash(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < chars.length; i++) {
            sb.append((char) ((chars[i] - chars[i - 1] + 26) % 26 + 'a'));
        }

        return sb.toString();
    }
}
